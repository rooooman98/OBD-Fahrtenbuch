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
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMain;
    private List<LogbookData> logbookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rvMain);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvMain.setLayoutManager(layoutManager);
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
    List<MainActivity.LogbookData> logbookDataList;
    Context mContext;

    RVAdapter(List<MainActivity.LogbookData> logbookList, Context c){
        this.logbookDataList = logbookList;
        this.mContext = c;
    }

    @NonNull
    @Override
    public LogbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item, viewGroup, false);
        LogbookViewHolder lvh = new LogbookViewHolder(v);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LogbookViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return logbookDataList.size();
    }

    public static class LogbookViewHolder extends RecyclerView.ViewHolder {
        CardView cvLogbook;
        TextView logbookName;

        LogbookViewHolder(View itemView) {
            super(itemView);
            cvLogbook = (CardView)itemView.findViewById(R.id.cvDrive);
            logbookName = (TextView)itemView.findViewById(R.id.tvDrive);
        }
    }
}