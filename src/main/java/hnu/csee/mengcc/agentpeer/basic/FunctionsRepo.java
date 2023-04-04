package hnu.csee.mengcc.agentpeer.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FunctionsRepo {

  public void InvokeCommandAtSpecifiedPath(String[] commands, String path)
    throws InterruptedException {
    ProcessBuilder processBuilder = new ProcessBuilder(commands);
    processBuilder.directory(new File(path));
    processBuilder.redirectErrorStream(true);
    Process process;
    try {
      process = processBuilder.start();
      //        通过标准输入流来拿到正常和错误的信息
      InputStream inputStream = process.getInputStream();
      BufferedReader input = new BufferedReader(
        new InputStreamReader(inputStream)
      );
      String ss = null;
      while ((ss = input.readLine()) != null) {
        System.out.println(ss);
      }
      process.waitFor();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
