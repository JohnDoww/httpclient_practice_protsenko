import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.*;
import utils.Pet;
import utils.PetMethods;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetTest {

    PetMethods petMethods = new PetMethods();
    Pet pet = new Pet();
    HttpResponse response;

    @Test
    @Order(2)
    public void createPet() throws IOException {
        response = petMethods.createPet();
        assertEquals(SC_OK, response.getStatusLine().getStatusCode());
    }

    @Test
    @Order(3)
    public void findCreatedPet() throws IOException {
        response = petMethods.findPet(pet.getId());

        assertEquals(SC_OK, response.getStatusLine().getStatusCode());
    }

    @Test
    @Order(3)
    public void updatePet() throws IOException {
        response = petMethods.updatePet();
//        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
//        System.out.println("Response body: " + responseBody);

        assertEquals(SC_OK, response.getStatusLine().getStatusCode());
    }

    @Test
    @Order(4)
    public void deleteCreatedPet() throws IOException {
        response = petMethods.deletePet();

        assertEquals(SC_OK, response.getStatusLine().getStatusCode());
    }

    @Test
    @Order(1)
    public void checkInventar() throws IOException {
        response = petMethods.getInventar();
        assertEquals(SC_OK, response.getStatusLine().getStatusCode());
    }


}

