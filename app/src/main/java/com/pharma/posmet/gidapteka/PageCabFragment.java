package com.pharma.posmet.gidapteka;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;


public class PageCabFragment extends Fragment {

    private int pageNumber;

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
        String str = position==0 ? "Мои заказы":(position==1?"Избранное":(position==2?"Любимые аптеки":(position==3?"Ожидаемое":"Напоминания")));
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
                break;
            case 2:
                result = inflater.inflate(R.layout.fragment_pharms, container, false);
                break;
            default:
                result = inflater.inflate(R.layout.fragment_page, container, false);
                TextView pageHeader = (TextView) result.findViewById(R.id.displayText);
                String str = pageNumber == 0 ? getResources().getString(R.string.page21) : (pageNumber == 1 ? getResources().getString(R.string.page22) : (pageNumber == 2 ? getResources().getString(R.string.page23) :(pageNumber == 2 ? getResources().getString(R.string.page24) : getResources().getString(R.string.page25))));
                pageHeader.setText("Фрагмент " + str);
        }
        return result;

    }

}