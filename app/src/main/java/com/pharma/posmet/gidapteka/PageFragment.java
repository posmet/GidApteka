package com.pharma.posmet.gidapteka;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PageFragment extends Fragment implements OnMapReadyCallback {

    private int pageNumber;
    private GoogleMap mMap;

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
        String str = position==0 ? "Акции,скидки":(position==1?"Каталог":(position==2?"Аптеки":"Заказы"));
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
                result = inflater.inflate(R.layout.fragment_map, container, false);
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map);
                mapFragment.getMapAsync(this);
                break;
            default:
                result = inflater.inflate(R.layout.fragment_page, container, false);
                TextView pageHeader = (TextView) result.findViewById(R.id.displayText);
                String str = pageNumber == 0 ? getResources().getString(R.string.page1) : (pageNumber == 1 ? getResources().getString(R.string.page2) : (pageNumber == 2 ? getResources().getString(R.string.page3) : getResources().getString(R.string.page4)));
                pageHeader.setText("Фрагмент " + str);
        }
        return result;

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}