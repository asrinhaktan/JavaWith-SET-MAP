import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Collator;
import java.util.*;

public class LastNameComparator implements Comparator<Kisiler> {

    public int compare(Kisiler ilk, Kisiler son){
        return ilk.getLastName().compareTo(son.getLastName());
    }

    public static ArrayList<Kisiler> sirala() throws Exception {
        ArrayList<Kisiler> liste = Kisiler.getirKisiler();
        Collections.sort(liste, new LastNameComparator());
        return liste;
    }

    public  static void yazdir(ArrayList<Kisiler> kisiler) throws IOException {
        File dosya = new File("/Users/asrinhaktansahin/Desktop/contactsArrayListOrderByLastName.txt");

        FileWriter yazici = new FileWriter(dosya, true);
        BufferedWriter yaz = new BufferedWriter(yazici);

        for (Kisiler c:kisiler) {
            yaz.write(c.getSocialSecurityNumber() +" "+ c.getFirstName() +" " + c.getLastName() +" "+ c.getPhoneNumber() +"\n");
        }
        yaz.close();
    }
}
