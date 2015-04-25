package net.caspervg.tusk4j;

import net.caspervg.tusk4j.auth.Auth;
import net.caspervg.tusk4j.bean.BasicConversation;
import net.caspervg.tusk4j.bean.result.CreateConvoResult;
import net.caspervg.tusk4j.bean.result.GetConvoResult;
import net.caspervg.tusk4j.bean.result.RegistrationResult;
import net.caspervg.tusk4j.bean.result.SessionResult;
import net.caspervg.tusk4j.bean.input.UserInput;
import net.caspervg.tusk4j.route.ConvoRoute;
import net.caspervg.tusk4j.route.UserRoute;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TuskHttpTest {

    private static String username, password, email;
    private static String session;
    private static String id;

    @BeforeClass
    public static void setUp() {
        Random random = new Random();
        username = "TUSK_TESTUSER_" + Math.abs(random.nextInt());
        password = "password_" + Math.abs(random.nextInt());
        email = username + "@example.com";
    }

    @Test
    public void a_testRegistration() {
        UserRoute route = new UserRoute();

        RegistrationResult result = route.postRegistration(new UserInput(username, password, email));
        assertEquals("Registered successfully", result.getInfo());
        assertNull(result.getError());
    }

    @Test
    public void b_testSession() {
        UserRoute route = new UserRoute();

        SessionResult result = route.getSession(new UserInput(username, password));
        assertNotNull(result.getSession());
        assertTrue(result.getSession().length() > 0);
        assertNull(result.getError());

        session = result.getSession();
    }

    @Test
    public void c_testCreateConvo() {
        ConvoRoute route = new ConvoRoute(new Auth(username, session));

        CreateConvoResult result = route.createConvo("TUSK_TESTCONVO", Collections.singletonList(username));
        assertNotNull(result.getId());
        assertTrue(result.getId().length() > 0);
        assertNull(result.getError());

        id = result.getId();
    }

    @Test
    public void d_testGetConvos() {
        ConvoRoute route = new ConvoRoute(new Auth(username, session));

        List<BasicConversation> convos = route.getConvos();
        assertNotNull(convos);
        assertEquals(1, convos.size());
        assertEquals(id, convos.get(0).getId());
        assertEquals("TUSK_TESTCONVO", convos.get(0).getTitle());
        assertEquals(username, convos.get(0).getParticipants().get(0));
    }

    @Test
    public void e_testGetConvo() {
        ConvoRoute route = new ConvoRoute(new Auth(username, session));

        GetConvoResult result = route.getConvo(id);
        assertNotNull(result.getConversation());
        assertNull(result.getError());
        assertEquals("TUSK_TESTCONVO", result.getConversation().getTitle());
        assertEquals(username, result.getConversation().getParticipants().get(0));
    }
}
