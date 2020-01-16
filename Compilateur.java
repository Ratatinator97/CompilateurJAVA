import java.lang.reflect.*;
import java.util.*;
import java.io.*;

public class Compilateur {
    public static void main(String[] args) throws Exception {
        String nom = args[0];
        Class interface = null;
        interface = Class.forName(nom);
        Method[] methods = interface.getDeclaredMethods();
        String[] methods_str = [];
        for (Method method : methods) {
            // do what you have to do with the method
            methods_str += method.getName());
        }
        generation_sekelton(methods_str);
        generation_stub(methods_str);
    }
    public static void generation_stub(String[] methodes){
        
        String stub_text = "java.net.Socket s = new java.net.Socket(\"127.0.0.1\",12345);\n
        java.io.DataOutputStream dos = new java.io.DataOutputStream(s.getOutputStream());\n
        java.io.ObjectInputStream ois = new java.io.ObjectInputStream(s.getInputStream());\n";

        for(String methode : methodes){
            String stub_methodes = ""
        }

    }
    public static void generation_sekelton(String[] methodes){
        String skeleton_text = "java.net.ServerSocket sos = new java.net.ServerSocket(12345);\n
        java.net.Socket s = sos.accept();\n
        java.io.DataInputStream dis = new java.io.DataInputStream(s.getInputStream());\n
        java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(s.getOutputStream());\n";
        
        String skeleton_methodes ="";
        for(String methode : methodes){
            skeleton_methodes += "String fonction = dis.readUTF();\n
            if (fonction.equals("+methode+")) {\n
                m = new "+methode+"(dis.readInt());\n
                oos.writeObject(m);\n
            }\n";

        }
    }
}