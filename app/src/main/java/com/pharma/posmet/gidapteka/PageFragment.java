package com.pharma.posmet.gidapteka;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView;
import android.widget.ListView;

public class PageFragment extends Fragment {

    private int pageNumber;
    private List<Drug> drugs = new ArrayList();
    ListView drugsList;
    ListView pharmsList;

    public PageFragment() {
    }

    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    static String getTitle(Context context, int position) {
       // String str = position==1 ? Context.getResources().getString(R.string.page1):(position==2?Context.getResources().getString(R.string.page2):(position==3?Context.getResources().getString(R.string.page3):getResources().getString(R.string.page4)));
        String str = position==0 ? "Акции,скидки":(position==1?"Каталог":(position==2?"Аптеки":"Корзина"));
        return str;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    private void createMapView() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result;
        switch (pageNumber) {
            case 0:
              //  result = inflater.inflate(R.layout.fragment_html, container, false);
              //  WebView webBrowser = (WebView) result.findViewById(R.id.WebView);
              //  webBrowser.loadData("<html><body><h1>Акция - скидки на все!</h1></body></html>", "text/html", "UTF-8");
              //  break;
                result = inflater.inflate(R.layout.fragment_image, container, false);
            break;
            case 1:
                result = inflater.inflate(R.layout.fragment_list, container, false);
                setInitialData(result.getContext(),0);
                drugsList = (ListView) result.findViewById(R.id.drugsList);
                DrugAdapter drugAdapter = new DrugAdapter(container.getContext(),R.layout.list_drug,drugs);
                drugsList.setAdapter(drugAdapter);
                AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                        Drug selectedDrug = (Drug)parent.getItemAtPosition(position);
                        Intent intent = new Intent(parent.getContext(),DrugActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);

                    }
                };
                break;
            case 2:
                result = inflater.inflate(R.layout.fragment_pharms, container, false);
         //       List<String> pharms = getResources().getStringArray(R.array.pharms);
         //       ArrayAdapter<String> adapter = new ArrayAdapter(container.getContext(),R.layout.fragment_pharms,pharms);
                pharmsList = (ListView) result.findViewById(R.id.pharmsList);
         //       pharmsList.setAdapter(adapter);
         //       pharmsList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
          //          @Override
          //          public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                     //   Intent intent = new Intent(parent.getContext(), PharmActivity.class);
                     //   intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                     //   startActivity(intent);

            //        }
            //    });
                break;
            case 3:
                result = inflater.inflate(R.layout.fragment_list_o, container, false);
                setInitialData(result.getContext(),2);
                drugsList = (ListView) result.findViewById(R.id.drugsList);
                DrugAdapter drugAdapter1 = new DrugAdapter(container.getContext(),R.layout.list_drug,drugs);
                drugsList.setAdapter(drugAdapter1);
                break;

            default:
                result = inflater.inflate(R.layout.fragment_page, container, false);
                TextView pageHeader = (TextView) result.findViewById(R.id.displayText);
                String str = pageNumber == 0 ? getResources().getString(R.string.page1) : (pageNumber == 1 ? getResources().getString(R.string.page2) : (pageNumber == 2 ? getResources().getString(R.string.page3) : getResources().getString(R.string.page4)));
                pageHeader.setText("Фрагмент " + str);
        }
        return result;

    }
    private void setInitialData(Context v,int q){
        String[] names = getResources().getStringArray(R.array.drugs);
        String[] makers = getResources().getStringArray(R.array.makers);
        String[] arts = getResources().getStringArray(R.array.arts);
        String[] prices = getResources().getStringArray(R.array.prices);
        if (q==0)
            for (int i=0;i<names.length;i++) {
                drugs.add(new Drug(names[i], arts[i],getResources().getIdentifier("p" + arts[i],"drawable",v.getPackageName()) , makers[i], prices[i]));
            }
        else
            for (int i=3;i<5;i++) {
                drugs.add(new Drug(names[i], arts[i],getResources().getIdentifier("p" + arts[i],"drawable",v.getPackageName()) , makers[i], "1"));
            }
    }

}