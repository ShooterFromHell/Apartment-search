package com.vladimir.myapplication.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vladimir.myapplication.Model.FindApartmentById;
import com.vladimir.myapplication.Model.ID;
import com.vladimir.myapplication.Controller.NetworkService;
import com.vladimir.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment implements View.OnClickListener {

    private ArrayList<com.vladimir.myapplication.Model.City> cities;

    String[] states = {"Винницкая", "Житомирская", "Тернопольская", "Хмельницкая", "Львовская",
            "Черниговская", "Харьковская", "Сумская", "Ровенская", "Киевская", "Днепропетровская",
            "Одесская", "Донецкая", "Запорожская", "Ивано-Франковская", "Кировоградская",
            "Луганская", "Волынская", "Николаевская", "Полтавская", "АР Крым(недоступно)", "Закарпатская",
            "Херсонская", "Черкасская", "Черновицкая",};

    String[] rooms_count = {"1", "2", "3", "4+"};
    Button btnStart;
    Spinner city;
    TextView result;
    EditText priceFrom, priceTo, areaFrom, areaTo, kitchenFrom, kitchenTo, floorFrom, floorTo;
    static final String API_KEY = "puRz51BtXNSlzWcpNj51qJ6deUi8vjJfmg70byu1";
    Integer itemId, itemId2, itemId3;
    String url = "https://dom.ria.com/uk/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment, container, false);
        result = view.findViewById(R.id.tv_result);
        btnStart = view.findViewById(R.id.find);
        btnStart.setOnClickListener(this);
        city = view.findViewById(R.id.spin_city);
        priceFrom = view.findViewById(R.id.et_price_from);
        priceTo = view.findViewById(R.id.et_price_to);
        areaFrom = view.findViewById(R.id.et_area_from);
        areaTo = view.findViewById(R.id.et_area_to);
        kitchenFrom = view.findViewById(R.id.et_kitchen_from);
        kitchenTo = view.findViewById(R.id.et_kitchen_to);
        floorFrom = view.findViewById(R.id.et_floor_from);
        floorTo = view.findViewById(R.id.et_floor_to);

        cities = new ArrayList<>();

        Spinner spinner = view.findViewById(R.id.states);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, states);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemId = (int) id + 1;
                City find = new City();
                find.execute();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);

        Spinner rooms = view.findViewById(R.id.spin_rooms);
        ArrayAdapter<String> room = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, rooms_count);
        room.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rooms.setAdapter(room);
        AdapterView.OnItemSelectedListener itemSelectedListener2 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemId2 = (int) id + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        rooms.setOnItemSelectedListener(itemSelectedListener2);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.find:
                Progress progress = new Progress();
                progress.execute();
                btnStart.setVisibility(View.INVISIBLE);
                break;
        }
    }

    class City extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            NetworkService.getInstance()
                    .getJSONApi()
                    .getCity(itemId, API_KEY)
                    .enqueue(new Callback<List<com.vladimir.myapplication.Model.City>>() {
                        @Override
                        public void onResponse(@NonNull Call<List<com.vladimir.myapplication.Model.City>> call, @NonNull Response<List<com.vladimir.myapplication.Model.City>> response) {
                            cities.clear();
                            assert response.body() != null;
                            cities.addAll(response.body());
                            String[] cityName = new String[cities.size()];
                            for (int i = 0; i < cities.size(); i++) {
                                cityName[i] = cities.get(i).getName();
                            }
                            ArrayAdapter<String> area = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, cityName);
                            // Определяем разметку для использования при выборе элемента
                            area.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            // Применяем адаптер к элементу spinner
                            city.setAdapter(area);

                            AdapterView.OnItemSelectedListener itemSelectedListener3 = new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    itemId3 = cities.get((int) id).getCityID();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            };
                            city.setOnItemSelectedListener(itemSelectedListener3);
                        }

                        @Override
                        public void onFailure(@NonNull Call<List<com.vladimir.myapplication.Model.City>> call, @NonNull Throwable t) {
                            Toast.makeText(getActivity(), "Error occurred while getting request!", Toast.LENGTH_SHORT).show();
                            t.printStackTrace();
                        }
                    });
            return null;
        }
    }

    class Progress extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            String priceF = priceFrom.getText().toString();
            int price_f = Integer.parseInt(priceF);
            String priceT = priceTo.getText().toString();
            int price_t = Integer.parseInt(priceT);
            String areaF = areaFrom.getText().toString();
            int area_f = Integer.parseInt(areaF);
            String kitchenF = kitchenFrom.getText().toString();
            int kitchen_f = Integer.parseInt(kitchenF);
            String floorF = floorFrom.getText().toString();
            int floor_f = Integer.parseInt(floorF);
            String areaT = areaTo.getText().toString();
            int area_t = Integer.parseInt(areaT);
            String kitchenT = kitchenTo.getText().toString();
            int kitchen_t = Integer.parseInt(kitchenT);
            String floorT = floorTo.getText().toString();
            int floor_t = Integer.parseInt(floorT);
            NetworkService.getInstance()
                    .getJSONApi()
                    .findId(API_KEY, 1, 2, 3, itemId, itemId3, 244, price_f, price_t, 0, itemId2, area_f, area_t, kitchen_f, kitchen_t, floor_f, floor_t)
                    .enqueue(new Callback<ID>() {
                        @Override
                        public void onResponse(@NonNull Call<ID> call, @NonNull Response<ID> response) {
                            ID id = response.body();
                            result.setText("");
                            if (id.getItems().length == 0)
                                result.setText(R.string.not_found);
                            else {
                                for (int i = 0; i < id.getItems().length; i++) {
                                    NetworkService.getInstance()
                                            .getJSONApi()
                                            .getApartmentById(id.getItems()[i], API_KEY)
                                            .enqueue(new Callback<FindApartmentById>() {
                                                @Override
                                                public void onResponse(@NonNull Call<FindApartmentById> call, @NonNull Response<FindApartmentById> response) {
                                                    FindApartmentById findApartmentById = response.body();
                                                    if (findApartmentById.getDescription() != "")
                                                        result.append(findApartmentById.getDescription() + "\n");
                                                    else
                                                        result.append(findApartmentById.getDescription_uk() + "\n");
                                                    result.append(url + findApartmentById.getBeautiful_url() + "\n");
                                                }

                                                @Override
                                                public void onFailure(@NonNull Call<FindApartmentById> call, @NonNull Throwable t) {
                                                    Toast.makeText(getActivity(), "Error occurred while getting request!", Toast.LENGTH_SHORT).show();
                                                    t.printStackTrace();
                                                }
                                            });
                                }
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<ID> call, @NonNull Throwable t) {
                            Toast.makeText(getActivity(), "Error occurred while getting request!", Toast.LENGTH_SHORT).show();
                            t.printStackTrace();
                        }
                    });

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            btnStart.setVisibility(View.VISIBLE);
        }
    }

}