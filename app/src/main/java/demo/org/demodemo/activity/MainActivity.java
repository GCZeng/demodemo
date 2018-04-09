package demo.org.demodemo.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import demo.org.demodemo.R;
import demo.org.demodemo.activity.base.BaseActivity;
import demo.org.demodemo.widget.BarChart;

public class MainActivity extends BaseActivity {

    private BarChart barChart;

    private List<Integer> charDataList = null;

    private Random random = null;

    @Override
    protected int providerLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        barChart = findViewById(R.id.barChart);

    }

    @Override
    protected void initData() {
        charDataList = new ArrayList<>();
        random = new Random();

        //生成数据
        for (int i = 0; i < 10; i++) {
            charDataList.add(random.nextInt(100));
        }

        barChart.init(charDataList);

    }

}
