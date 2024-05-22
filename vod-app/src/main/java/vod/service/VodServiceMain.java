//package vod.service;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import vod.repository.GameMuseumDao;
//import vod.repository.GameDao;
//import vod.repository.mem.MemGameMuseumDao;
//import vod.repository.mem.MemGameDao;
//import vod.model.GamesMuseum;
//import vod.service.impl.GameMuseumServiceBean;
//
//import java.util.List;
//
//public class VodServiceMain {
//
//    public static void main(String[] args) {
//        System.out.println("Let's find museums!");
//
//        ApplicationContext context = new AnnotationConfigApplicationContext("vod");
//
//        GameMuseumService service = context.getBean(GameMuseumService.class);
//
//
//        List<GamesMuseum> gamesMuseums = service.getAllMuseums();
//        System.out.println(gamesMuseums.size() + " museums found:");
//        gamesMuseums.forEach(System.out::println);
//        String foo = context.getBean(String.class);
//        System.out.println("Foo: " + foo); //foo + bar from configuration
//    }
//}
