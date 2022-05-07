package com.rgbitsoft.exam.design.signleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemAccess{

    private static final String SYSTEM_OS = System.getProperty("os.name");
    /**
     * 싱글톤 패턴
     */
    private static SystemAccess instance = null;

    private SystemAccess() {
    }

    public static SystemAccess getInstance() {
        synchronized (SystemAccess.class) {
            if (instance == null) {
                instance = new SystemAccess();
            }
            return instance;
        }
    }

    /**
     * @name getSystemOS
     * @apiNote : 시스템 OS 정보를 리턴 (ex. Windows 10) -> OS마다 커맨드라인이 다르다.
     * @param args : 쉘 커맨드라인
     * @throws RuntimeException
     */
    public String getSystemOS() {
        return SYSTEM_OS;
    }

    /**
     * @name getAppRoot
     * @apiNote : 어플리키에션 작업폴더 경로를 가져온다.
     * @return String
     */
    public String getAppRoot() {
        return System.getProperty("user.dir");
    }

    /**
     * @name runExec
     * @apiNote : System 커맨드 명령을 실행한다.
     * @param args : 쉘 커맨드라인
     * @throws RuntimeException
     * @return Process
     */
    public Process runExec(String[] args) throws RuntimeException {

        try {
            return Runtime.getRuntime().exec(args);
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            // process.destroy(); 프로그램은 사용중에 열려있어야 하기 때문에
        }
    }

    /**@name    destroy
     * @apiNote                          : 자식 프로세스를 대기시킨다.
     * @param   process                  : 프로세스
     * @throws  RuntimeException
     * @return  Process
     */
    public void waitFor(Process process) throws InterruptedException {
        if(process !=null)
            process.waitFor();
    }

    /**@name    destroy
     * @apiNote                          : 자식 프로세스를 종료시킨다.
     * @param   process                  : 프로세스
     * @throws  RuntimeException
     * @return  Process
     */
    public void destroy(Process process) {
        if(process !=null)
            process.destroy();

    }


    /**@name    runExecAndGetString
     * @apiNote                          : 커맨드 명령을 실행 후 문자열을 읽어온다.
     * @param   process                  : 프로세스
     * @throws  RuntimeException
     * @return  Process
     */
    public String runExecAndGetString(String[] args) {
        Process p = null;
        StringBuilder sb = null;
        String resultStr = "";
        try {
            p = Runtime.getRuntime().exec(args);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"EUC-KR"));
            sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            resultStr = sb.toString();
            sb = null;
        }catch (Exception e) {
            throw new RuntimeException();
        }finally {
            System.out.println("자식 프로세스 종료시 까지 대기합니다.");
            try {
                p.waitFor();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("자식 프로세스 종료");
            p.destroy();
        }
        return resultStr;
    }
    public int getProcessID(int port) throws IOException {
        Process ps = new ProcessBuilder("cmd", "/c", "netstat -a -o").start();
        BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains(":" + port)) {
                while (line.contains("  ")) {
                    line = line.replaceAll("  ", " ");
                }
                int pid = Integer.valueOf(line.split(" ")[5]);
                ps.destroy();
                return pid;
            }
        }
        //Runtime.getRuntime().exec("taskkill /F /PID " + pid);

        return -1;
    }

    public static void main(String[] args) throws IOException {
        SystemAccess sa = SystemAccess.getInstance();
        String os = sa.getSystemOS();
        boolean isWindows = false;
        if (os.toLowerCase().contains("windows")) {
            isWindows = true;
        }

        String appRootPath = sa.getAppRoot();

        System.out.println(appRootPath);
        String filePath = appRootPath + "/module-exam/src/main/resources/markdown/oop.md";

        System.out.printf("[%s] -> windows is %s\n", os, isWindows);
        Process process;

        if (isWindows) {
            // 메모장 프로그램으로 연다.
            process = sa.runExec(new String[] { "notepad.exe", filePath});

            System.out.println(process.pid());

            String result = sa.runExecAndGetString(new String[]{"ipconfig"});
            System.out.println(result);
        } else {
            // 리눅스 일때
            // 맥 OS일때
        }

        System.out.println();
       // System.out.println("8080 PORT PROCESS PID : " + sa.getProcessID(8080));

    }
}
