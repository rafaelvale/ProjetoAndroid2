package com.stg.achados.achadoseperdidos;

        import android.location.Address;
        import android.location.Geocoder;
        import android.support.v4.app.FragmentActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;

        import org.w3c.dom.Text;

        import java.io.IOException;
        import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

            private GoogleMap mMap;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                LatLng sp = new LatLng(-23, -46);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sp));
            }

            @Override
            protected void onResume(){
                super.onResume();
                setUpMapIfNeeded();
            }

            public void onSearch(View view){

                EditText location_tf = (EditText)findViewById(R.id.TFaddress);
                String location = location_tf.getText().toString();

                List<Address> addressList = null;


                if(location != null || !location.equals("")){
                    Geocoder geocoder = new Geocoder(this);
                    try{
                        addressList = geocoder.getFromLocationName(location, 1);
                    }catch (IOException e){
                        e.printStackTrace();
                    }

                    Address address = addressList.get(0);

                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
                    mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

                    Toast.makeText(getApplication(),latLng.toString(),Toast.LENGTH_LONG).show();



                }

            }

            private void setUpMapIfNeeded(){
                if (mMap == null){
                    mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                            .getMap();
                if (mMap != null) {
                    setUpMap();
                }
                }

            }


            private void setUpMap(){

                mMap.setMyLocationEnabled(true);
            }
}
