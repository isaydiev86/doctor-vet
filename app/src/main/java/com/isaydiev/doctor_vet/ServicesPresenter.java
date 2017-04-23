package com.isaydiev.doctor_vet;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.isaydiev.doctor_vet.Models.Item;


import org.json.JSONException;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by USER on 11.04.2017.
 */

public class ServicesPresenter implements ServiceContract.Presenter {

    private Context context;
    private ServiceContract.View view;
    private ArrayList<Item> serviceList;
    private DataBase db;
    private ApiInterface apiInterface;

    public ServicesPresenter(Context context, ServiceContract.View view) {
        this.context = context;
        this.view = view;
        apiInterface = ApiClient.getInstance2().create(ApiInterface.class);
        db = new DataBase(context);
    }

    @Override
    public void loadServiceList() {
        if(!db.getServicesList().isEmpty()){
            view.showServicesList(db.getServicesList());
        }else {

            Call<JsonElement> objectCall = apiInterface.getServices();
            objectCall.enqueue(new Callback<JsonElement>() {
                @Override
                public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                    JsonElement element = response.body();
                    JsonObject object = element.getAsJsonObject();
                    serviceList = new ArrayList<Item>();
                    JsonArray treeArray = object.getAsJsonArray("tree");
                    for (int i = 0; i < treeArray.size(); i++) {
                        Item mainItem = new Item();
                        JsonObject level1 = treeArray.get(i).getAsJsonObject();
                        mainItem.setId(level1.get("id").getAsInt());
                        mainItem.setParent_id(level1.get("parent_id").getAsInt());
                        mainItem.setTitle(level1.get("title").getAsString());
                        //mainItem.setLevel(level1.get("level").getAsInt());
                        //ArrayList<Item> mainList = new ArrayList<Item>();
                        //JsonArray itemArray = level1.getAsJsonArray("items");
//                        for (int j = 0; j < itemArray.size(); j++) {
//                            JsonObject level2 = itemArray.get(j).getAsJsonObject();
//                            Item item2 = new Item();
//                            item2.setId(level2.get("id").getAsInt());
//                            item2.setParent_id(level2.get("parent_id").getAsInt());
//                            item2.setTitle(level2.get("title").getAsString());
//                            item2.setPrice(level2.get("price").getAsString());
//                            item2.setPayable(level2.get("payable").getAsBoolean());
//                            item2.setCost(level2.get("cost").getAsInt());
//                            item2.setLevel(level2.get("level").getAsInt());
//                            if (level2.get("items").isJsonArray()){
//                                JsonArray lastArray = level2.get("items").getAsJsonArray();
//                                ArrayList<Item> lastList = new ArrayList<Item>();
//                                for (int k = 0; k < lastArray.size(); k++) {
//                                    JsonObject level3 = lastArray.get(k).getAsJsonObject();
//                                    Item lastItem = new Item();
//                                    lastItem.setId(level3.get("id").getAsInt());
//                                    lastItem.setParent_id(level3.get("parent_id").getAsInt());
//                                    lastItem.setTitle(level3.get("title").getAsString());
//                                    lastItem.setPrice(level3.get("price").getAsString());
//                                    lastItem.setPayable(level3.get("payable").getAsBoolean());
//                                    lastItem.setCost(level3.get("cost").getAsInt());
//                                    lastItem.setLevel(level3.get("level").getAsInt());
//                                    lastItem.setItems(null);
//                                    lastList.add(lastItem);
//                                }
//                                item2.setItems(lastList);
//                            }else {
//                                item2.setItems(null);
//                            }
//                        }
                        //mainItem.setItems(mainList);
                        serviceList.add(mainItem);
                    }
                    db.insertServicesList(serviceList);
                    view.showServicesList(db.getServicesList());
                }

                @Override
                public void onFailure(Call<JsonElement> call, Throwable t) {
                    view.showError("onFailure: "+t.getMessage());
                }
            });
        }

    }
}
