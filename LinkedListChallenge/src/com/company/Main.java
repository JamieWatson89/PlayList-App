package com.company;



import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();


    public static void main(String[] args) {

        Album album = new Album("Wash it away","FFDP");

        album.addSong("Wash it all away",5.45);
        album.addSong("Wrong side of heaven",4.45);
        album.addSong("Trouble",2.45);
        album.addSong("Remember Everything",5.45);
        album.addSong("House of the rising sun",4.45);
        album.addSong("I apologize",3.45);
        album.addSong("Jekyll and Hyde",4.45);
        album.addSong("The Pride",3.45);


        albums.add(album);

        album = new Album("For those about to rock","ACDC");

        album.addSong("For those about to rock",4.56);
        album.addSong("I put the finger on you",5.62);
        album.addSong("Let's get it up",3.56);
        album.addSong("Inject the venom",4.23);
        album.addSong("Snowballed",2.56);
        album.addSong("Evil Walks",5.23);
        album.addSong("Breaking the rules",4.55);

        albums.add(album);

        LinkedList<Song> playList =  new LinkedList<Song>();

        albums.get(0).addToPlaylist("Trouble",playList);
        albums.get(0).addToPlaylist("The Pride",playList);
        albums.get(0).addToPlaylist("Remember Everything",playList);
        albums.get(0).addToPlaylist("Wash it all away",playList);
        albums.get(1).addToPlaylist("Evil Walks",playList);
        albums.get(1).addToPlaylist("Breaking the rules",playList);
        albums.get(1).addToPlaylist("Inject the venom",playList);



    }

    private static void play(LinkedList<Song> playList) {
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size()==0){
            System.out.println("No songs on your playlist.");
            return;
        }else{
            System.out.println("Now playing -->> " + listIterator.next().toString());
        }

        boolean quit = false;
        boolean forward = true;
        menu();
        while(!quit){
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0 :
                    System.out.println("Now quiting playlist.....");
                    quit = true;break;
                case 1 : if(!forward){
                            if(listIterator.hasNext()){
                                listIterator.next();
                                forward = true;} }
                         if(listIterator.hasNext()){
                                System.out.println("Now playing -->> " + listIterator.next());}
                         else{
                             System.out.println("You're at the end of the list.");
                             forward = false;
                         }
                            break;

                case 2 :if(forward){
                            if(listIterator.hasPrevious()){
                                listIterator.previous();
                                forward = false;}}

                                if(listIterator.hasPrevious()){
                                System.out.println("Now playing -->> "+listIterator.previous());
                            }else{
                                System.out.println("You're at the start of the playlist");
                                forward = true;
                            }

                            break;

                case 3 :
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing -->> " + listIterator.previous());
                            forward= false;
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now playing -->> " + listIterator.next());
                            forward = true;
                        }else{
                            System.out.println("We are at the end of the list");
                        }
                    }

                    break;

                case 4 :printList(playList);
                        System.out.println("");
                        menu();
                        break;

                case 5 :
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing -->> " + listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Now playing -->> " + listIterator.previous());
                        }
                    }


                    menu();
                    break;

            }
        }


    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("========= PLAYLIST =========");
       while (iterator.hasNext()){
           System.out.println(iterator.next());
       }
        System.out.println("============================");
    }

    private static void menu() {
        System.out.println( "0 - To Quit\n"+
                            "1 - To go to next song\n"+
                            "2 - To go to previous song\n"+
                            "3 - To repeat song\n"+
                            "4 - Show playlist\n"+
                            "5 - To remove song from playlist");
    }

}
