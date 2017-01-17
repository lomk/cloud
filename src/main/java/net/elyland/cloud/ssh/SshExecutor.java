package net.elyland.cloud.ssh;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by imaterynko on 16.01.17.
 */
public class SshExecutor {

    private static String USERNAME ="imaterynko";
    private static String PASSWORD ="aria4768506";
    private static String host = "127.0.0.1";

    private static int port=22;

    public List<String> executeCommand(String command) {

        List<String> result = new ArrayList<String>();
        JSch jsch = new JSch();

        try {
            Session session = jsch.getSession(USERNAME, host, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(PASSWORD);
            session.connect();

            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            InputStream in = channelExec.getInputStream();
            channelExec.setCommand(command);
            channelExec.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;

            while ((line = reader.readLine()) != null)
            {
                result.add(line);
            }

            int exitStatus = channelExec.getExitStatus();

            channelExec.disconnect();
            session.disconnect();

            if (exitStatus < 0) {
            } else if (exitStatus > 0) {
            } else {
                // System.out.println("Done!");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return result;

    }

}
