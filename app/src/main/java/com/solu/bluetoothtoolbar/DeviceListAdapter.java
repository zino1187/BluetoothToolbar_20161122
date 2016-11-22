package com.solu.bluetoothtoolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DeviceListAdapter extends BaseAdapter{
    Context context;
    ArrayList<Device> list = new ArrayList<Device>();
    LayoutInflater inflater;

    public DeviceListAdapter(Context context) {
        this.context=context;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return list.size();
    }
    public Object getItem(int i) {
        return list.get(i);
    }
    public long getItemId(int i) {
        return 0;
    }
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view=null;
        Device dto=list.get(i);

        if(convertView==null){//지금 새로 인플레이션하여 아이템 새로 생성
            view=inflater.inflate(R.layout.device_item, null);
        }else{//그냥 그대로 사용할 거야..내용만 바꿔서...
            view=convertView;
        }
        TextView txt_name=(TextView) view.findViewById(R.id.txt_name);
        TextView txt_address=(TextView) view.findViewById(R.id.txt_address);
        txt_name.setText(dto.getName());
        txt_address.setText(dto.getAddress());

        return view;
    }
}
