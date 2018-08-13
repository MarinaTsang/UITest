# UITest
11、ConstraitLayout的使用

官方教程：https://developer.android.com/reference/android/support/constraint/ConstraintLayout

- 基本概念：约束布局，封装在support 包中，类似与相对布局，但比相对布局性能高。可以解决多层嵌套问题。
- 基本用法：
  视图化操作：https://blog.csdn.net/guolin_blog/article/details/53122387
  - 若没有添加任何约束，默认叠加在左上角，类似于 FrameLayout结果。所以拖拽的地方并不是最终显示的地方。
  - 添加约束：周围的四个圆圈。拖动比例。
  - 删除约束：删除某一个（圆圈）；删除整个控件约束；删除整个布局的约束。
  - 控件的大小控制：
    - 》》》：表示wrap_content.
    - |---|:表示固定大小。
    - |~~|：表示any size，类似于match_parent,是属于Constraint布局的独有大小控制方式，由于约束布局是解决嵌套布局的，所以match_parent 较为少用。类似match_parent的值利用0dp(match_contraint)及约束达到效果。
    - Gildeline:默认是dp尺寸，一般更改为百分比，一般用于居中约束。
  - 自动添加约束：
    - Autoconnect:Truns on Autoconnet,根据屏幕拖动的意图自动添加约束，可能需要微调,使用与给一个控件添加约束。
    - Inference：Infer Constraits比Autoconnet功能强大，适用于给整个布局添加约束。
  代码操作：https://blog.csdn.net/lmj623565791/article/details/78011599
  - 基本属性
    - 相对位置Relative positioning，类似于相对布局：app:layout_constraintLeft_toRightOf  表示当前控件属性的左侧在某一控件的右侧。比如控件A在控件B的右侧，控件A的约束情况为：app:layout_constraintLeft_toRightOf= “@id/viewB” ,或者在app:layout_constraintLeft_toLeftOf="parent"表示在布局最左侧。
    - Chains:链提供同一个方向轴的同一个操作，类似于APP下的tabbar.可使用app:layout_constraintHorizontal（Vertical）_weight进行比例分配。在chains head 可以使用 app:layout_constraintHorizontal_chainStyle设置链表模式，不同模式搭配 是否是match_constrain展现不同效果。
      - spread：居中等分，当宽（高）为0 时间隔等分，是0时无间隔等分。默认模式。
      - spread_inside:与spread类似，但链条终点不会被分散开。
      - Packed:链条内的元素会被打包紧挨一起。
    - Bias：偏移量，一般用于设置小部件偏移屏幕的多少，例如右下角的悬浮按钮的设置。layout_constraintHorizontal_bias
    - 角度：可约束某一控件在另一控件中心为圆心的半径多少之内。layout_constraintCircle,layout_constraintCircleRadius,layout_constraintCircleAngle.
    - Ratio比例约束：使用比例，控件的宽高至少有一个需要设置为 MATCH_CONSTRAINT (0dp)，使用app:layout_constraintDimensionRatio="1:1"设置比例宽：高。如果宽和高都设置为match_constraint(0dp),可以通过声明W或H设置约束边，如app:layout_constraintDimensionRatio=H,16:6,即宽高比为16：6，表示高度=宽度（6：16），如果是 W,16:6，会超出全屏，宽是被约束的,表示高度=宽度（16：6）
    - Guideline:辅助线，辅助线不会出现在布局中，添加辅助线之后，约束的对象可以相对于辅助线而不是其他view或parent。
- 性能解析
  - Android 视图绘制过程
    - 测量：系统自顶向下遍历视图树进行测量以确定viewgroup和view元素的大小，在测量viewgroup的同时也会测量其子view。
    - 布局：系统开启另一个自顶向下的遍历操作，每个viewgroup根据测量阶段确定的大小确定其子view的位置。
    - 绘制：系统再次执行另一个自顶向下的遍历操作，系统为视图树的每个对象创建一个canvas对象，以便向CPU发送一个绘制的命令列表，命令包含前两个阶段测量和布局确定的viewgroup和view的大小和位置。
  - 当遇到复杂布局时，需要多层嵌套达到设计效果，嵌套越多执行上面的步骤开销就越大。可以使用Systrace查看布局消耗的性能。
  - 测量性能差异：可使用 Android 7.0（API 级别 24）中引入的 OnFrameMetricsAvailableListener分析不同布局测量需要的时间。经测试，同样设计布局，使用Constraintlayout 比RelatRelativelayout快40%。
