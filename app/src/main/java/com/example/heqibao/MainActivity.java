package com.example.heqibao;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.heqibao.base.BaseActivity;
import com.example.heqibao.base.BasePresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private TextView titleName;
    private Banner banner;
    private RelativeLayout rl;
    private RelativeLayout rl1;
    private RelativeLayout rl2;
    private RelativeLayout rl3;
    private TextView textSelectCard;
    private TextView textVipCard;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void initView() {
        titleName = (TextView) findViewById(R.id.title_name);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "suxinshi.ttf");
        titleName.setTypeface(typeface);
        banner = (Banner) findViewById(R.id.banner);
        rl = (RelativeLayout) findViewById(R.id.rl);
        rl1 = (RelativeLayout) findViewById(R.id.rl_1);
        rl2 = (RelativeLayout) findViewById(R.id.rl_2);
        rl3 = (RelativeLayout) findViewById(R.id.rl_3);
        textSelectCard = (TextView) findViewById(R.id.text_select_card);
        textVipCard = (TextView) findViewById(R.id.text_vip_card);
        initBanner();
        initlistener();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    private void initlistener() {
        rl.setOnClickListener(new View.OnClickListener() {

            private ImageView miCard;
            private ImageView wx;
            private ImageView zhifubao;

            @Override
            public void onClick(View view) {
                //用自己写的样式替换context的样式
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View inflate = View.inflate(MainActivity.this, R.layout.dialog2, null);
                builder.setView(inflate);
                AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
                Window dialogWindow = dialog.getWindow();
                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                lp.x = 5; // 新位置X坐标
                lp.y = 20; // 新位置Y坐标
                lp.width = 375; // 宽度
                lp.height = 290; // 高度
                //lp.alpha = 0.7f; // 透明度
                dialogWindow.setAttributes(lp);

                zhifubao = (ImageView)inflate.findViewById(R.id.zhifubao);
                wx = (ImageView) inflate.findViewById(R.id.wx);
                miCard = (ImageView) inflate.findViewById(R.id.mi_card);
                zhifubao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "支付宝支付" , Toast.LENGTH_SHORT).show();
                    }
                });
                wx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "微信支付" , Toast.LENGTH_SHORT).show();
                    }
                });
                miCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "密卡支付" , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        rl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        rl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        rl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        textSelectCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //用自己写的样式替换context的样式
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View inflate = View.inflate(MainActivity.this, R.layout.dialog, null);
                builder.setView(inflate);
                AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
                Window dialogWindow = dialog.getWindow();
                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                lp.x = 5; // 新位置X坐标
                lp.y = 20; // 新位置Y坐标
                lp.width = 375; // 宽度
                lp.height = 290; // 高度
/*
                lp.alpha = 0.7f; // 透明度
*/
                dialogWindow.setAttributes(lp);
            }
        });
        textVipCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //用自己写的样式替换context的样式
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View inflate = View.inflate(MainActivity.this, R.layout.dialog1, null);
                builder.setView(inflate);
                AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
                Window dialogWindow = dialog.getWindow();
                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                lp.x = 20; // 新位置X坐标
                lp.y = 20; // 新位置Y坐标
                lp.width = 375; // 宽度
                lp.height = 390; // 高度
                //lp.alpha = 0.7f; // 透明度
                dialogWindow.setAttributes(lp);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initBanner() {
        //放图片地址的集合
        List<String> list_path = new ArrayList<>();
        //设置图片数据
        list_path.add("https://shitu-query-nj.su.bcebos.com/2020-08-25/20/b2380d28faf2f800?authorization=bce-auth-v1%2F7e22d8caf5af46cc9310f1e3021709f3%2F2020-08-25T20%3A27%3A47Z%2F300%2Fhost%2F5b65a68bc926bd15830359f0e87173b9c68016b5a7d4df73e5b224ff35b61c7d");
        list_path.add("https://shitu-query-nj.su.bcebos.com/2020-08-25/20/be1215df9260fed1?authorization=bce-auth-v1%2F7e22d8caf5af46cc9310f1e3021709f3%2F2020-08-25T20%3A37%3A51Z%2F300%2Fhost%2Fd73845943f06b35b6e83e7fae5cef53fdfd672a9a4b448f0717f35790934d4eb");
        list_path.add("https://shitu-query-nj.su.bcebos.com/2020-08-25/20/9f2df7877c6c7edc?authorization=bce-auth-v1%2F7e22d8caf5af46cc9310f1e3021709f3%2F2020-08-25T20%3A38%3A44Z%2F300%2Fhost%2F3835f91502bf998661f4c880a3f996bce86a9aca18e0ea91cd8d0aac4b634902");
/*
        list_path.add("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=2816348942,2191669895&os=3211227188,3407353748&simid=3397886663,92969854&pn=105&rn=1&di=234520&ln=1546&fr=&fmq=1598359995093_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=3c&hs=2&objurl=http%3A%2F%2Fpic5.nipic.com%2F20100116%2F3004787_144103081367_2.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined");
*/
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.TITLE_BACKGROUND);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).centerCrop().into(imageView);
            }
        });
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播间隔时间
        banner.setDelayTime(5000);
        //设置是否为自动轮播，默认是“是”
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                //必须最后调用的方法，启动轮播图。
                .start();
        banner.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 15);
            }
        });
        banner.setClipToOutline(true);

    }
}