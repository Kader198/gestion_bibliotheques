import com.service.LivreService;
import com.service.UserService;
import entity.Livre;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();

//        boolean oui = service.login("admin","admin");
//        System.out.println("logged variable = "+oui);
//        LivreService livreService = new LivreService();
//        Livre livre = new Livre("la roché",120.0,1);
//        livreService.addLivre(livre);
//        System.out.println(" livre ajouté avec succés ");

        LivreService livreService = new LivreService();
        List<Livre> Livres = livreService.getAllLivre();
        for (Livre livre: Livres) {
            System.out.println(livre.getLibelle());
        }
    }
}
