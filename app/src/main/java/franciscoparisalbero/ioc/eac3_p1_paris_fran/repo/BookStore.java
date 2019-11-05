package franciscoparisalbero.ioc.eac3_p1_paris_fran.repo;

import java.util.ArrayList;
import java.util.List;

import franciscoparisalbero.ioc.eac3_p1_paris_fran.model.Book;

public class BookStore {

    private static List<Book> mBooks;

    public static Book get(int id) {
        return mBooks.get(id - 1);
    }

    public static List<Book> getAllBooks() {
        return mBooks;
    }

    public static void createBookList() {
        mBooks = new ArrayList<>();
        for (int i = 0; i < BookInfo.BOOK_INFO.length; i++) {
            Book book = new Book();
            book.setId(i + 1);
            book.setTitle(BookInfo.BOOK_INFO[i][0]);
            book.setSummary(BookInfo.BOOK_INFO[i][1]);
            mBooks.add(book);
        }
    }

    private static class BookInfo {

        private static String[][] BOOK_INFO = {
                {"PARAULES QUE TU ENTENDRAS", "Tots els grans amors tenen secrets.\n" +
                        "Aquella tarda no van tenir pressa. No els empaitava ningú i les hores es " +
                        "negaven a avançar. Van tornar a la ciutat sense posar la música del cotxe, " +
                        "van esborrar la boira del camí i van retrobar la pau de saber que ja no els" +
                        " quedaven preguntes urgents per fer-se.\n" + "\n" +
                        "La Mara Lincoln, aventurera incansable, organitza viatges exclusius per als" +
                        " seus clients. El Xavi Vera, arquitecte d’èxit, rep l’encàrrec de dissenyar" +
                        " la casa de la seva vida. La parella es disposa a brindar per l’any nou en " +
                        "un hotel als Alps suïssos, amb els quatre amics de sempre.\n" + "\n" +
                        "Tots sis riuen, juguen i són feliços, però res no és mai el que sembla. " +
                        "L’any que enceten pot canviar-ho tot."},
                {"EL PINTOR D ANIMES", "Una poderosa història d'amor, passió per l'art, revoltes " +
                        "socials i venjança a la Barcelona modernista.\n" + "\n" +
                        "Barcelona, 1901. La ciutat viu dies de gran agitació social. L'absoluta " +
                        "misèria dels més desfavorits contrasta amb l'elegant opulència de les grans" +
                        " avingudes, on destaquen alguns edificis singulars, símbol de l'arribada " +
                        "del modernisme.\n" + "\n" +
                        "En Dalmau Sala, fill d'un anarquista ajusticiat, és un jove pintor que viu " +
                        "atrapat entre dos móns. D'una banda, la seva família i l'Emma, la dona que" +
                        " estima, són fermes defensores de la lluita obrera; homes i dones que no " +
                        "coneixen la por a"},
                {"LA NOIA QUE VA VIURE DUES VEGADES (MILLENNIUM 6)", "La Lisbeth Salander està " +
                        "preparada per a la batalla final contra l’única persona que, tot i ser-li " +
                        "idèntica, li és del tot oposada: la seva germana Camila. Aquesta vegada, " +
                        "però, la Lisbeth prendrà la iniciativa. S’alliberarà del mal i el dolor de " +
                        "tota una vida. Durant mesos, la Lisbeth s’ha estat acostant al seu objectiu:" +
                        " ha deixat enrere Estocolm, porta un pentinat nou i s’ha tret els piercings." +
                        " Sembla una executiva més, però les executives no amaguen una pistola sota " +
                        "l’americana, no són hackers expertes ni tenen cicatrius i tatuatges que els " +
                        "fan recordar que han sobreviscut a l’impossible. En Mikael Blomkvist, d’altra " +
                        "banda, està investigant la mort d’un sense sostre de qui només se sap que " +
                        "ha mort mentre pronunciava el nom del ministre de Defensa del govern suec i que"},
                {"LA MEMORIA DE L AIGUA: PREMI PRUDENCI BERTRANA 2019", "Una nova veu literària que " +
                        "recorda Mirall trancat.\n" +
                        "Aquesta és la història de tres generacions de dones: la Clemència, rossa " +
                        "com un fil d’or, nascuda a Bellparatge a finals del segle XIX; la seva filla" +
                        " Rosalia, que viurà tot el procés d’industrialització, i la Núria, neta de " +
                        "la Clemència, que lluitarà per tenir la formació, la llibertat sexual i " +
                        "l’amor que no van tenir mai la seva mare ni la seva àvia. La misèria, el " +
                        "maltractament, la incomunicació i la discriminació marquen les vides d’aquestes " +
                        "dones a la Catalunya més pobra, però també el poder de la reconciliació i " +
                        "de la superació determinen el destí final de les protagonistes. Una novel·la " +
                        "èpica i colpidora que és, alhora, el relat ocult de moltes dones. Una memòria " +
                        "que no s’ha d’oblidar mai."},
                {"ON ÉS L ESTEL-LA? FESTES I TRADICIONS CATALANES", "UN JOC PER A TOTA LA FAMÍLIA, " +
                        "PER SEGUIR BUSCANT L’ESTEL·LA. AQUESTA VEGADA, PER LES PRINCIPALS FESTES I " +
                        "TRADICIONS CATALANES L’Estel·la no para! Aquesta noia és un belluguet! " +
                        "Cercaviles, carnavals, Sant Jordi, festes del menjar, jornades castelleres," +
                        " Nadal, balls tradicionals, correfocs... L’Estel·la és una experta de primera " +
                        "magnitud en les dèries festives dels catalans. Si aconsegueixes trobar-la " +
                        "en cada escenari d’aquest recorregut i identifiques totes les festes i " +
                        "tradicions que s’hi representen, et mereixeràs una bona recompensa."},
                {"CANTO JO I LA MUNTANYA BALLA, Les dues torres", "4t. Premi Llibres Anagrama de Novel·la\n" +
                        "Primer hi ha la tempesta i el llamp i la mort d’en Domènec, el pagès poeta. " +
                        "Després, la Dolceta, que no pot parar de riure mentre explica les històries " +
                        "de les quatre dones penjades per bruixes. La Sió, que ha de pujar tota sola " +
                        "la Mia i l’Hilari allà dalt a Matavaques. I les trompetes de la mort que, " +
                        "amb el seu barret negre i apetitós, anuncien la immutabilitat del cicle de " +
                        "la vida."},
                {"ASSAIG GENERAL D UNA REVOLTA: LES CLAUS DEL PROCES CATALA", "Les lliçons que cal " +
                        "treure del procés català.\n" +
                        "El procés independentista català ha esdevingut la crisi més important d’Espanya " +
                        "des de la instauració de la democràcia. El que durant dècades va ser \"el " +
                        "problema catalán\" ha canviat de dimensió i s’ha convertit en un fenomen nou, " +
                        "estretament vinculat a les disfuncions de la democràcia espanyola i a les " +
                        "tensions de l’Europa dels nostres dies. Dos milions de ciutadans han abraçat " +
                        "el projecte d’una Catalunya independent, en un canvi de mentalitat col·lectiva " +
                        "vertiginós des de l’any 2010. "}

        };
    }
}