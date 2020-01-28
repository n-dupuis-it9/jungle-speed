package ndps.student.jungle.server;//FINI

import ndps.student.jungle.work.game.Game;

import java.io.*;
import java.net.*;

public class JungleServer {

    public final static int REQ_LISTPARTY = 1;
    public final static int REQ_CREATEPARTY = 2;
    public final static int REQ_JOINPARTY = 3;
    public final static int REQ_WAITPARTYSTARTS = 4;
    public final static int REQ_WAITTURNSTARTS = 5;
    public final static int REQ_PLAY = 6;

    public final static int ACT_NOP = 1;
    public final static int ACT_TAKETOTEM = 2;
    public final static int ACT_HANDTOTEM = 3;
    public final static int ACT_INCORRECT = 4;

    public static void  main(String []args) {

        ServerSocket conn = null;
        Socket comm = null;
        Game game = null;
        int port = 12345;
        ThreadServer t = null;

        try {
            conn = new ServerSocket(port);
        }
        catch(IOException e) {
            System.out.println("Erreur à la création du serveur : "+e.getMessage());
            System.exit(1);
        }

        game = new Game();

        while (true) {
            try {

                comm = conn.accept();
                t = new ThreadServer(game, comm);
                t.start();

            }
            catch(IOException e) {
                System.out.println("Problème de connection : "+e.getMessage());
            }
        }
    }
}

