import com.sun.org.apache.bcel.internal.generic.GOTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;
//****************************************** NIE DZIALA **************
public class Main {
    static Map<Node,Boolean> mapa = new HashMap<>();
    public static int start_x,start_y,koniec_x,koniec_y;
    public static void main(String[] args) throws FileNotFoundException {

        String sciezka = "labirynt_29x29.txt",linia;
        List<String> lista_wierszy = new ArrayList<>();
        int licznik_wierszy=0;

        Scanner odczyt = new Scanner(new File(sciezka));
        linia=odczyt.nextLine();
        System.out.println(linia);

        while (odczyt.hasNextLine() == true) {
                linia = odczyt.nextLine();
                licznik_wierszy++;
            System.out.println(linia);
            lista_wierszy.add(linia);
        }


        for(int wiersz=0;wiersz<licznik_wierszy;wiersz++)
        {
            for(int kolumna=0;kolumna<29;kolumna++)
            {

                if(lista_wierszy.get(wiersz).charAt(kolumna)==' ')
                {
                    mapa.put(new Node(wiersz,kolumna,"puste"),false);
                }
                else if(lista_wierszy.get(wiersz).charAt(kolumna)=='a')
                {
                    mapa.put(new Node(wiersz,kolumna,"start"),false);
                    start_x=wiersz;
                    start_y=kolumna;
                }
                else if(lista_wierszy.get(wiersz).charAt(kolumna)=='b')
                {
                    mapa.put(new Node(wiersz,kolumna,"koniec"),false);
                    koniec_x=wiersz;
                    koniec_y=kolumna;
                }
            }
        }

        Node poczatek=new Node(start_x,start_y,"start");
        Node meta=new Node(koniec_x,koniec_y,"koniec");
        System.out.println(poczatek);
        System.out.println(meta);
        System.out.println(BFS(poczatek,meta));

    }

    static int[] wiersz={0,0,1,-1};
    static int[] kolumna={-1,1,0,0};

    public static int BFS(Node start, Node end) {
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        int dystans=0;
        //visited.put(start, false);
        while (!q.isEmpty()) {
            Node n = q.poll();

            if (n.x == end.x && n.y == end.y) {
                return n.distance;
            }
            if (visited.get(n) == null) { //jesli node nieodwiedzony
                visited.put(n, true); //to juz odwiedzony
                for (int i = 0; i < 8; i++) {
                    if (validate(n.x + kolumna[i], n.y + wiersz[i])) {
                        Node temp =  new Node(n.x + kolumna[i], n.y + wiersz[i]);
                        dystans++;
                        q.add(temp);
                        //                  visited.put(temp, false);
                    }
                }

            }
        }

        return -1;
    }

    public boolean validate(int x,int y)
    {

    }
}
