import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {


       //kişileri arrayliste atma
       Kisiler.contactArrayList(Kisiler.getirKisiler());


        //kişileri arrayliste atıp soy isime göre sıralama
        LastNameComparator.yazdir(LastNameComparator.sirala());


        //Hashseti dosyaya yazdırma
        HashSetSinifi.HashSetGonder(HashSetSinifi.getirKisiler());

        //Treeseti soyada göre yazdırma
        contactTreeSetOrderByLastName.yazdir(contactTreeSetOrderByLastName.sirala());


        //HASHMAP ile dosyaya yazdırma
       String dosyaYolu = "/Users/asrinhaktansahin/Desktop/contacts.txt";
        HashMap<String, String> map = new HashMap<String, String>();

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu));
        while ((line = reader.readLine()) != null)
        {
            String[] parca = line.split(" ", 2);
            if (parca.length >= 2)
            {
                String anahtar = parca[0];
                String deger = parca[1];
                map.put(anahtar, deger);
            } else {
                System.out.println("hata: " + line);
            }
        }

        String dosyaYolu2 = "/Users/asrinhaktansahin/Desktop/file.txt";

        File file = new File(dosyaYolu2);
        FileWriter yazici = new FileWriter(dosyaYolu2, true);
        BufferedWriter yaz = new BufferedWriter(yazici);

        for (String key : map.keySet()) {
            yaz.write(key+" --> "+map.get(key)+"\n");
        }
        yaz.close();
    }
}