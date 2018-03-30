package sang.com.weathermode.drawable.color;

public class SkyBackground {

    //黑色背景
    public static final Integer[] BLACK = new Integer[]{0xff000000, 0xff000000};
//		public static final Integer[] CLEAR_D = new Integer[] { 0xff3d99c2, 0xff4f9ec5 };
//		public static final Integer[] CLEAR_N = new Integer[] { 0xff0d1229, 0xff262c42 };

    //晴天
    public static final Integer[] CLEAR_D = new Integer[]{0xff3d99c2, 0xff4f9ec5};
    public static final Integer[] CLEAR_N = new Integer[]{0xff0b0f25, 0xff252b42};
    //阴天
    public static final Integer[] OVERCAST_D = new Integer[]{0xff33425f, 0xff617688};//0xff748798, 0xff617688
    public static final Integer[] OVERCAST_N = new Integer[]{0xff262921, 0xff23293e};//0xff1b2229, 0xff262921
    // 雨天
    public static final Integer[] RAIN_D = new Integer[]{0xff4f80a0, 0xff4d748e};
    public static final Integer[] RAIN_N = new Integer[]{0xff0d0d15, 0xff22242f};
    // 雾
    public static final Integer[] FOG_D = new Integer[]{0xff688597, 0xff44515b};
    public static final Integer[] FOG_N = new Integer[]{0xff2f3c47, 0xff24313b};

    //下雪
    public static final Integer[] SNOW_D = new Integer[]{0xff4f80a0, 0xff4d748e};//临时用RAIN_D凑数的
    public static final Integer[] SNOW_N = new Integer[]{0xff1e2029, 0xff212630};
    // 多云
    public static final Integer[] CLOUDY_D = new Integer[]{0xff4f80a0, 0xff4d748e};//临时用RAIN_D凑数的
    public static final Integer[] CLOUDY_N = new Integer[]{0xff071527, 0xff252b42};// 0xff193353 };//{ 0xff0e1623, 0xff222830 }
    //霾
    public static final Integer[] HAZE_D = new Integer[]{0xff616e70, 0xff474644};// 0xff999b95, 0xff818e90
    public static final Integer[] HAZE_N = new Integer[]{0xff373634, 0xff25221d};

    //沙
    public static final Integer[] SAND_D = new Integer[]{0xffb5a066, 0xffd5c086};//0xffa59056
    public static final Integer[] SAND_N = new Integer[]{0xff312820, 0xff514840};
}
