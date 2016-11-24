package ua.com.e2k;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


@Controller
@RequestMapping("/")
public class MyController {



    @RequestMapping("/")
    public String onIndex() {
        System.out.println("!!!!");
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String onLogin(Model model, @RequestParam String name, @RequestParam String age) {
//        Добавление в базу
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAMenu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new User(name,age));
        em.getTransaction().commit();
        em.close();

//        Достаем

        em = emf.createEntityManager();
        List<User> list=null;
        try{
            Query q = em.createQuery("from User");
            list = q.getResultList();
        } finally {
            em.close();
        }



        model.addAttribute("list", list);

        return "result";
    }
}
