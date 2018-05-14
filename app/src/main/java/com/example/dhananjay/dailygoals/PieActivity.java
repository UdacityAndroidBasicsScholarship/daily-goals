package com.example.dhananjay.dailygoals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
//TODO: implement this interface OnChartValueSelectedListener and show the data in a dialogue box as showMessage
public class PieActivity extends AppCompatActivity {

    //Data X is for lables and Y is for plotting...........................
    private String dataX[] = {"swim", "dance", "cycle", "iDontKnow", "WhoCares", "NoBodyDoes"};
    private float dataY[] = {24.4f, 49.54f, 69.0f, 69.3f, 96f, 35.9f};
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_demo);

        pieChart = (PieChart) findViewById(R.id.pieChart);

        String desc = "Hello world";
        //piechart properties for beautification and features...............................
        //pieChart.setDescription(desc); not working in mine
        pieChart.setRotationEnabled(true);//it lets you spin this shit lika fidget spinner, hellya!
        pieChart.setTransparentCircleAlpha(3);//keep it as it is,its for 3d effect
        pieChart.animateXY(3000,3000);//vary as per requirement


        // loadDataFormFirebase();
        loadPieWithData(pieChart);
    }

    /**
     * yData for storing values
     * xData for its lables
     * @param chart
     */
    private void loadPieWithData(PieChart chart) {
        ArrayList<PieEntry> yData = new ArrayList<>();
        ArrayList<String> xData = new ArrayList<>();

        for(int i = 0;i< dataY.length;i++) {
            yData.add(new PieEntry(dataY[i]));
            xData.add(dataX[i]);
        }

        PieDataSet pieDataSet = new PieDataSet(yData,"counts");

        pieDataSet.setSliceSpace(3);//gap between slices
        pieDataSet.setValueTextSize(14);

        //add colors to dataset
//TODO:make this random color generator when/if list of tasks are many
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.MAGENTA);
        pieDataSet.setColors(colors);

        //setting legend as per documentation
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        //legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //PieData data = new PieData(xData, pieDataSet);


        //desc of piechart change it for diff tasks
        chart.getDescription().setText("Overview of Today");
        chart.getDescription().setTextSize(18);
        chart.getDescription().setPosition(15f,5f);// this method is not working,need help!


        //create pie data object DO_NOT_TOUCH
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();


    }
    /*
     * in this method use firebase reference and store data in
     * String dataX[] array and float dataY[] array
     *
     * firstly calculate the number of tasks and run the for loop accordingly to store data
     *
     * */
    public void loadDataFormFirebase(){


    }
}