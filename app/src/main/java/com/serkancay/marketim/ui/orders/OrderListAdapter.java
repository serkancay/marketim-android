package com.serkancay.marketim.ui.orders;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.serkancay.marketim.R;
import com.serkancay.marketim.data.network.model.Order;
import com.serkancay.marketim.ui.orders.OrderListAdapter.OrderHolder;
import com.serkancay.marketim.util.CalendarUtil;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created by S.Serkan Cay on 22.09.2019
 */

public class OrderListAdapter extends Adapter<OrderHolder> {

    private final int RESOURCE = R.layout.item_order_list;

    public static class OrderHolder extends ViewHolder {

        @BindView(R.id.llRootButton)
        LinearLayout llRootButton;

        @BindView(R.id.ivProductState)
        ImageView ivProductState;

        @BindView(R.id.llOrderDetail)
        LinearLayout llOrderDetail;

        @BindView(R.id.tvDate)
        TextView tvDate;

        @BindView(R.id.tvMarketName)
        TextView tvMarketName;

        @BindView(R.id.tvMonth)
        TextView tvMonth;

        @BindView(R.id.tvOrderDetail)
        TextView tvOrderDetail;

        @BindView(R.id.tvOrderName)
        TextView tvOrderName;

        @BindView(R.id.tvProductPrice)
        TextView tvProductPrice;

        @BindView(R.id.tvProductState)
        TextView tvProductState;

        @BindView(R.id.tvSummaryPrice)
        TextView tvSummaryPrice;

        public OrderHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private List<Order> mOrders;

    public OrderListAdapter(List<Order> orders) {
        mOrders = orders;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(RESOURCE, parent, false);
        OrderHolder holder = new OrderHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final OrderHolder holder, final int position) {
        Order order = mOrders.get(position);
        boolean isExpanded = order.isExpanded();
        holder.llOrderDetail.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.tvDate.setText(order.getDate());
        holder.tvMonth.setText(CalendarUtil.getMonthName(order.getMonth()));
        holder.tvMarketName.setText(order.getMarketName());
        holder.tvOrderName.setText(order.getOrderName());
        holder.tvProductPrice.setText(NumberFormat.getCurrencyInstance().format(order.getProductPrice()));
        holder.tvProductState.setText(order.getProductState());
        holder.tvOrderDetail.setText(order.getProductDetail().getOrderDetail());
        holder.tvSummaryPrice
                .setText(NumberFormat.getCurrencyInstance().format(order.getProductDetail().getSummaryPrice()));
        // String value check. Have not any state value from the api.
        if (order.getProductState().equals("Yolda")) {
            holder.ivProductState.setColorFilter(Color.parseColor("#27ae60"));
            holder.tvProductState.setTextColor(Color.parseColor("#27ae60"));
        } else if (order.getProductState().equals("Hazırlanıyor")) {
            holder.ivProductState.setColorFilter(Color.parseColor("#e67e22"));
            holder.tvProductState.setTextColor(Color.parseColor("#e67e22"));
        } else if (order.getProductState().equals("Onay Bekliyor")) {
            holder.ivProductState.setColorFilter(Color.parseColor("#c0392b"));
            holder.tvProductState.setTextColor(Color.parseColor("#c0392b"));
        }
        holder.llRootButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                order.setExpanded(!isExpanded);
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mOrders.size();
    }

    public void addItems(List<Order> orders) {
        if (mOrders != null) {
            mOrders.clear();
            mOrders.addAll(orders);
        }
        notifyDataSetChanged();
    }
}
