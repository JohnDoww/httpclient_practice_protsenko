package utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PetMethods extends Exception {
    public PetMethods() {
    }

    Links links = new Links();
    HttpResponse response;
    File file;


    public HttpResponse createPet() throws IOException {
        file = new File("src/main/java/utils/petInfo.json");
        FileEntity fileEntity = new FileEntity(file, ContentType.create("application/json", "UTF-8"));

        HttpPost createPetRequest = new HttpPost(links.GET_CREATE_PET());
        createPetRequest.setEntity(fileEntity);

        response = HttpClientBuilder.create().build().execute(createPetRequest);
        return response;
    }

    public HttpResponse updatePet() throws IOException {
        file = new File("src/main/java/utils/updatepet.json");
        FileEntity fileEntity = new FileEntity(file, ContentType.create("application/json", "UTF-8"));

        HttpPost createPetRequest = new HttpPost(links.GET_CREATE_PET());
        createPetRequest.setEntity(fileEntity);
        response = HttpClientBuilder.create().build().execute(createPetRequest);
        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        if (responseBody.contains("chicki")) {
            return response;
        } else {
            String s = null;
            String error = s.toString();
        }
        return response;
    }

    public HttpResponse findPet(String petId) throws IOException {

        HttpGet findPetByIdRequest = new HttpGet(links.GET_FIND_PET_BY_ID() + petId);
        response = HttpClientBuilder.create().build().execute(findPetByIdRequest);

        return response;
    }

    public HttpResponse deletePet(String petId) throws IOException {

        HttpGet deletePetById = new HttpGet(links.GET_DELETE_PET_BY_ID() + petId);
        response = HttpClientBuilder.create().build().execute(deletePetById);
        return response;
    }

    public HttpResponse getInventar() throws IOException {
        HttpGet httpGetInventar = new HttpGet(links.GET_INVENTORY());
        response = HttpClientBuilder.create().build().execute(httpGetInventar);
        return response;

    }
}
