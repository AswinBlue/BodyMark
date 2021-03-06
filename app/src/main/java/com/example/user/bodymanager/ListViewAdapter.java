package com.example.user.bodymanager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.user.bodymanager.R.drawable.dummy;

/**
 * Created by user on 2017-06-19.
 */
public class ListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<Explain> listViewItemList = new ArrayList<Explain>() ;

    // ListViewAdapter의 생성자
    public ListViewAdapter() {
    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.explain_view, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView Image = (ImageView) convertView.findViewById(R.id.image_explain) ;
        TextView Seq = (TextView) convertView.findViewById(R.id.text_explain) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        Explain listViewItem = listViewItemList.get(position);
        context.getResources().getIdentifier( "icon", "drawable", null );

        // 아이템 내 각 위젯에 데이터 반영
        if(listViewItem.isVis() == false)
            Image.setVisibility(View.GONE);
        else
            Image.setVisibility(View.VISIBLE);

        Image.setImageDrawable(listViewItem.getImage());
        Seq.setText(listViewItem.getText());
        String tempColor = listViewItem.getColor();
        if(tempColor.equals("blue")) {
            Seq.setTextColor(Color.BLUE);
        }
        else if(tempColor.equals("black")) {
            Seq.setTextColor(Color.BLACK);
        }

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(Drawable icon,  boolean v, String title) {
        Explain item = new Explain();

        item.setVis(v);
        item.setImage(icon);
        item.setText(title);

        listViewItemList.add(item);
    }

    public void addItem(Drawable icon, boolean v, String title, String color) {
        Explain item = new Explain();

        item.setVis(v);
        item.setImage(icon);
        item.setText(title);
        item.setColor(color);

        listViewItemList.add(item);
    }
}
