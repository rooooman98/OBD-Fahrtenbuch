package tumaroma.loggle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMain;
    private ArrayList<LogbookData> logbookList = new ArrayList<LogbookData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rvMain);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvMain.setLayoutManager(layoutManager);
        RVAdapter rvAdapter = new RVAdapter(logbookList, getApplicationContext());
        rvMain.setAdapter(rvAdapter);
    }

    class LogbookData {
        String name;
        String category;
        Date lastChange;
        LogbookData (String n, String c, Date lC){
            this.name = n;
            this.category = c;
            this.lastChange = lC;
        }
    }
}
class RVAdapter extends RecyclerView.Adapter<RVAdapter.LogbookViewHolder>{
    ArrayList<MainActivity.LogbookData> logbookDataList;
    Context mContext;
    LogbookViewHolder lVH;

    RVAdapter(ArrayList<MainActivity.LogbookData> logbookList, Context c){
        this.logbookDataList = logbookList;
        this.mContext = c;
    }

    @NonNull
    @Override
    public LogbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.content_cardview, parent, false);
        lVH = new LogbookViewHolder(v);
        return lVH;
    }

    @Override
    public void onBindViewHolder(@NonNull LogbookViewHolder holder, int position) {
        lVH.tvLogbookName.setText("Fahrtenbuch zur Arbeit");
        lVH.tvLogbookType.setText("Fahrtenbuch");
        lVH.tvLogbookDate.setText("16.08.2018 17:19");
        lVH.ivIcon.setImageResource(R.drawable.book_icon);

    }

    @Override
    public int getItemCount() {
        //return logbookDataList.size();
        return 1;
    }

    public static class LogbookViewHolder extends RecyclerView.ViewHolder {
        CardView cvLogbook;
        TextView tvLogbookName;
        TextView tvLogbookType;
        TextView tvLogbookDate;
        ImageView ivIcon;

        LogbookViewHolder(View itemView) {
            super(itemView);
            cvLogbook = (CardView)itemView.findViewById(R.id.cvDrive);
            tvLogbookName = (TextView)itemView.findViewById(R.id.tvLogbookTitle);
            tvLogbookType = (TextView)itemView.findViewById(R.id.tvLogbookType);
            tvLogbookDate = (TextView)itemView.findViewById(R.id.tvLogbookDate);
            ivIcon = (ImageView)itemView.findViewById(R.id.ivIconLogbook);
        }
    }
}