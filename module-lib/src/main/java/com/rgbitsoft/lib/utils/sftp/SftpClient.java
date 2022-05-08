package com.rgbitsoft.lib.utils.sftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.SftpProgressMonitor;

import java.io.ByteArrayOutputStream;

public class SftpClient {
    private String host;
    private int port = 22;
    private String dir;
    private Session session;
    private Channel channel;
    private ChannelExec channelExec;
    private ChannelSftp channelSftp;
    private long percent = 0;

    public SftpClient() {}

    public SftpClient(String name, String password, String host, int port) {
        this.connect(name, password, host, port);
    }

    public SftpClient connect(String name, String password, String host, int port) {
        try {
            session = new JSch().getSession(name, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
        } catch (JSchException e) {
            e.printStackTrace();
        }

        return this;
    }

    public String command(String command) {
        if(session == null) {
            return "ssh 연결이 되지 않았습니다.";
        }else if(command == null || command.trim().equals("")) {
            return "명령어를 입력해주세요.";
        }

        String responseString = "";
        try {
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();

            channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(command);
            channelExec.setOutputStream(responseStream);
            channelExec.connect();
            while (channelExec.isConnected()) {
                Thread.sleep(100);
            }

            responseString = new String(responseStream.toByteArray());
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.disConnect();
        }
        return responseString;
    }

    public String fileSend(String OutPutPath, String DestinyPath) {
        percent = 0; //초기화
        if(session == null) {
            return "ssh 연결이 되지 않았습니다.";
        }else if(OutPutPath == null || DestinyPath == null) {
            return "경로가 정상적으로 등록되지 않았습니다.";
        }

        try {
            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            channelSftp.put(OutPutPath, DestinyPath, new SystemOutProgressMonitor());
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        } finally {
            this.disConnect();
        }
        return "정상적으로 전송하였습니다.";
    }

    public void disConnect() {
        if (session != null) {
            session.disconnect();
        }
        if (channel != null) {
            channel.disconnect();
        }
        if(channelExec != null) {
            channelExec.disconnect();
        }
        if(channelSftp != null) {
            channelSftp.disconnect();
        }
    }

    public long getSendPercent() {
        if(percent >= 100) {
            percent = 0;
            return (long)100;
        }
        return percent;
    }

    class SystemOutProgressMonitor implements SftpProgressMonitor {
        private long fileSize = 0;
        private long sendFileSize = 0;

        @Override
        public void init(int op, String src, String dest, long max) {
            this.fileSize = max;
            System.out.println("Starting : " + op + "  " + src + " -> " + dest + " total : " + max);
        }

        @Override
        public boolean count(long count) {
            this.sendFileSize += count;
            long p = this.sendFileSize * 100 / this.fileSize;
            if(p > percent) {
                percent++;
            }
            return true;
        }

        @Override
        public void end() {
            System.out.println("Finished!");
        }
    }

}
