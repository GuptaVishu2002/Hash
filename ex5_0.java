import java.io.*;

class ex5_0 {
  public static void main(String[] argv){
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      while(true){
        System.out.print("String: ");
        String line = br.readLine();
        if (line.equals("quit")) break;
        int t = 0;
        int s = 0;
        for(int i = 0; i < line.length(); i++){
          System.out.print("line.charAt(" + i + ") = [" + line.charAt(i)+ "]");
          s = line.charAt(i); // cast char to int
          System.out.println(" -> " + s);
          t = t + s;
        }
        System.out.println("total: " + t);
      }
      br.close();
    }catch(IOException e){
      System.out.println("Exception :" + e);
    }    
  }
}
