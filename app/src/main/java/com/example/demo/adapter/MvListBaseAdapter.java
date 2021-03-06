package com.example.demo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;


/**
 * BaseAdapter 实现简单的List的设配器
 * <p>
 * //自定义的list 适配器
 */

public class MvListBaseAdapter extends BaseAdapter {

    static List<Map<String, Object>> list;
    LayoutInflater inflater;
    private Context context;


    //上下文
    public MvListBaseAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;

    }

    //region 其他地方获取mv 数据就分开写了
    //传出数据 其他地方获取mv 数据就分开写了
    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    //自定义静态get 数据
    public static List<Map<String, Object>> getLits() {
        return list;
    }

    //endregion

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.item_list, null);

        TextView name = convertView.findViewById(R.id.name);
        TextView mvid = convertView.findViewById(R.id.mid);
        ImageView pmid_img = convertView.findViewById(R.id.pmid_img);


        Map map = list.get(position);
        name.setText((String) map.get("name"));
        mvid.setText((String) map.get("mid"));
        //  http://y.gtimg.cn/music/photo_new/T002R300x300M000000jE4g74VS43p.jpg
        Picasso.with(context).load(String.format("http://y.gtimg.cn/music/photo_new/T002R300x300M000%s.jpg", map.get("pmid_img"))).into(pmid_img);

//        String imd1 = "http://y.gtimg.cn/music/photo_new/T002R300x300M000";
//        String imd2 = ".jpg?max_age=2592000";
//        Picasso.with(context).load(imd1 + map.get("pmid_img") + imd2).into(pmid_img);

        return convertView;
    }
}
