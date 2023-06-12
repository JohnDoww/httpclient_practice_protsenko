package utils;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.ArrayList;

public class PetMethods extends Exception {
    public PetMethods() {
    }

    Links links = new Links();
    HttpPost post;
    HttpPut put;
    HttpGet get;
    HttpResponse response;
    Gson gson = new Gson();
    StringEntity petBody;

    int id = 123;
    String name;
    String originalName = "Gorik";
    String changedName = "Raul";
    String status = "available";
    String contentType = "Content-type";
    String applicationType = "application/json";
    ArrayList<String> photoUrls = new ArrayList<>();
    ArrayList<Pet.Tag> tags = new ArrayList<>();
    {
        tags.add(new Pet.Tag(id, "shy"));
    }

    Pet.Category category = new Pet.Category(id, name);
    Pet pet = new Pet(id, category, name, photoUrls, tags, status);


    public HttpResponse createPet() throws IOException {
        pet.setName(originalName);
        post = new HttpPost(links.GET_CREATE_PET());
        petBody = new StringEntity(gson.toJson(pet));
        pet.setName(changedName);
        post.setEntity(petBody);
        post.setHeader(contentType, applicationType);
        response = HttpClientBuilder.create().build().execute(post);
        return response;
    }

    public HttpResponse updatePet() throws IOException {
        pet.setName(changedName);
        put = new HttpPut(links.GET_CREATE_PET());
        petBody = new StringEntity(gson.toJson(pet));
        put.setEntity(petBody);
        put.setHeader(contentType, applicationType);
        response = HttpClientBuilder.create().build().execute(put);
        return response;
    }

    public HttpResponse findPet(int petId) throws IOException {
        get = new HttpGet(links.GET_FIND_PET_BY_ID() + pet.getId());
        response = HttpClientBuilder.create().build().execute(get);
        return response;
    }

    public HttpResponse deletePet() throws IOException {
        get = new HttpGet(links.GET_DELETE_PET_BY_ID() + pet.getId());
        response = HttpClientBuilder.create().build().execute(get);
        return response;
    }

    public HttpResponse getInventar() throws IOException {
        get = new HttpGet(links.GET_INVENTORY());
        response = HttpClientBuilder.create().build().execute(get);
        return response;

    }
}
