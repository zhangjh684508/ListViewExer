package com.gary.listviewexer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gary.listviewexer.bean.Fruit;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private List<Fruit> fruitList=new ArrayList<Fruit>();

    private String[] data={"Apple", "Banana", "Orange", "Pear","Apple", "Banana", "Orange", "Pear",
            "Apple", "Banana", "Orange", "Pear","Banana", "Orange", "Pear","Banana", "Orange", "Pear"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, data);
        */
        initFruits();

        FruitAdapter adapter=new FruitAdapter(MainActivity.this, R.layout.list_item_fruit, fruitList);

        mListView = (ListView)findViewById(R.id.activity_main_list_view);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit=fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getmName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

     private void initFruits()
    {
        Fruit apple=new Fruit("Apple", R.drawable.apple);
        fruitList.add(apple);

        Fruit banana=new Fruit("Banana", R.drawable.banana);
        fruitList.add(banana);

        Fruit orange=new Fruit("Orange", R.drawable.orange);
        fruitList.add(orange);

        Fruit pear=new Fruit("Pear", R.drawable.pear);
        fruitList.add(pear);

        Fruit grape=new Fruit("Grape", R.drawable.grape);
        fruitList.add(grape);
    }

    public class FruitAdapter extends ArrayAdapter<Fruit>
    {

        private int resourceId;

        public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects)
        {
            super(context, textViewResourceId, objects);
            resourceId=textViewResourceId;
        }

        @Override

        public View getView(int position, View convertView, ViewGroup parent)
        {
            Fruit fruit=getItem(position);

            View view;
            ViewHolder viewHolder;

            if (convertView==null)
            {
                viewHolder = new ViewHolder();
                view= LayoutInflater.from(getContext()).inflate(resourceId,null);
                viewHolder.fruitImage=(ImageView)view.findViewById(R.id.fruit_image);
                viewHolder.fruitName=(TextView)view.findViewById(R.id.fruit_name);
                view.setTag(viewHolder);
            }
            else
            {
                view =convertView;
                viewHolder=(ViewHolder)view.getTag();
            }

            //View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
            //ImageView fruitImage=(ImageView)view.findViewById(R.id.fruit_image);
            //TextView fruitName=(TextView)view.findViewById(R.id.fruit_name);

            viewHolder.fruitImage.setImageResource(fruit.getImageId());
            viewHolder.fruitName.setText(fruit.getmName());
            return view;
        }

        class ViewHolder
        {
            ImageView fruitImage;
            TextView fruitName;
        }

    }

}
