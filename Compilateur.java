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
    public static void generation_stub(String[] NomMethodes, Method[] ListeMethodes){
        String stub_core = ""; //TODO
        String stub_text = "java.net.Socket s = new java.net.Socket(\"127.0.0.1\",12345);\n
        java.io.DataOutputStream dos = new java.io.DataOutputStream(s.getOutputStream());\n
        java.io.ObjectInputStream ois = new java.io.ObjectInputStream(s.getInputStream());\n";
        String stub_methodes = "";
        for(Method Methode : NomMethodes){
            Parameter[] Parametres : Methode.getParameterNames();
            stub_methodes += Methode.toString() + "{\n
                dos.writeUTF("+Methode.getName()+");\n"
            for(Parameter Parametre : Parametres){
                stub_methodes+="dos.writeUTF("+Parametre.getName+");\n";
            }
            stub_methodes += "return ois.readObject()\n
            }\n"

            //TODO Ecrire sur fichier
        }

    }
    public static void generation_sekelton(String[] NomMethodes, Method[] ListeMethodes){
        String skeleton_core = ""; //TODO
        String skeleton_text = "java.net.ServerSocket sos = new java.net.ServerSocket(12345);\n
        java.net.Socket s = sos.accept();\n
        java.io.DataInputStream dis = new java.io.DataInputStream(s.getInputStream());\n
        java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(s.getOutputStream());\n";
        
        String skeleton_methodes ="";
        for(String NomMethode : NomMethodes){
            skeleton_methodes += "String fonction = dis.readUTF();\n
            if (fonction.equals("+NomMethode+")) {\n
                m = new "+NomMethode+"(dis.readInt());\n
                oos.writeObject(m);\n
            }\n";

        }
        //TODO Ecrire sur fichier
    }

}