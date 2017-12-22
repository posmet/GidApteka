package com.pharma.posmet.gidapteka;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.TextView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import java.util.ArrayList;
import java.util.List;


public class PageCabFragment extends Fragment {

    private int pageNumber;
    private List<Drug> drugs = new ArrayList();
    ListView drugsList;

    public PageCabFragment() {
    }

    public static PageCabFragment newInstance(int page) {
        PageCabFragment fragment = new PageCabFragment();
        Bundle args = new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    static String getTitle(Context context, int position) {
        // String str = position==1 ? Context.getResources().getString(R.string.page1):(position==2?Context.getResources().getString(R.string.page2):(position==3?Context.getResources().getString(R.string.page3):getResources().getString(R.string.page4)));
        String str = position==0 ? "Мои заказы":(position==1?"Избранное":(position==2?"Любимые аптеки":(position==3?"Ожидаемое":(position==4?"Напоминания":"Бонусные счета"))));
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
                  result = inflater.inflate(R.layout.fragment_html, container, false);
                  WebView webBrowser = (WebView) result.findViewById(R.id.WebView);
                  webBrowser.loadUrl("http://pharma-soft.ru:3000/public/Orders.html");
                  break;
            case 1:
                result = inflater.inflate(R.layout.fragment_list, container, false);
                setInitialData(result.getContext(),0);
                drugsList = (ListView) result.findViewById(R.id.drugsList);
                DrugAdapter drugAdapter = new DrugAdapter(container.getContext(),R.layout.list_drug,drugs);
                drugsList.setAdapter(drugAdapter);
                break;
            case 2:
                result = inflater.inflate(R.layout.fragment_pharms, container, false);
                break;
            case 3:
                result = inflater.inflate(R.layout.fragment_list, container, false);
                setInitialData(result.getContext(),0);
                drugsList = (ListView) result.findViewById(R.id.drugsList);
                DrugAdapter drugAdapter1 = new DrugAdapter(container.getContext(),R.layout.list_drug,drugs);
                drugsList.setAdapter(drugAdapter1);
                break;
            case 4:
                result = inflater.inflate(R.layout.fragment_html, container, false);
                WebView webBrowser1 = (WebView) result.findViewById(R.id.WebView);
                webBrowser1.loadUrl("http://pharma-soft.ru:3000/public/Remind.html");
                break;
            case 5:
                result = inflater.inflate(R.layout.fragment_html, container, false);
                WebView webBrowser2 = (WebView) result.findViewById(R.id.WebView);
                webBrowser2.loadUrl("http://pharma-soft.ru:3000/public/Bonus.html");
                break;
            default:
                result = inflater.inflate(R.layout.fragment_page, container, false);
                TextView pageHeader = (TextView) result.findViewById(R.id.displayText);
                String str = pageNumber == 0 ? getResources().getString(R.string.page21) : (pageNumber == 1 ? getResources().getString(R.string.page22) : (pageNumber == 2 ? getResources().getString(R.string.page23) :(pageNumber == 2 ? getResources().getString(R.string.page24) : getResources().getString(R.string.page25))));
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