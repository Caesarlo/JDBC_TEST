import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Score_System {

    public static void Search_By_Name(String stuName) {//通过名字查询
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();

            stmt=conn.createStatement();

            String sql="select * from stu_score where stu_name = '"+stuName+"'";
            rs=stmt.executeQuery(sql);
            System.out.println();
            System.out.println("    学号            姓名    性别    数据结构    英语    数学    体育    概率    平均分");
            while (rs.next()){
                String stu_id=rs.getString("stu_id");
                String stu_name=rs.getString("stu_name");
                String stu_gender=rs.getString("stu_gender");
                int stu_score_dataStructure=rs.getInt("stu_score_dataStructure");
                int stu_score_english=rs.getInt("stu_score_english");
                int stu_score_math=rs.getInt("stu_score_math");
                int stu_score_PE=rs.getInt("stu_score_PE");
                int stu_score_probability=rs.getInt("stu_score_probability");
                double stu_score_average=rs.getDouble("stu_score_average");
                System.out.println(stu_id+"       "+stu_name+"    "+stu_gender+"      "+stu_score_dataStructure+"        "+stu_score_english+"     "+stu_score_math+"     "+stu_score_PE+"     "+stu_score_probability+"      "+stu_score_average);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,stmt,rs);
        }
    }

    public static void Search_By_ID(String stuID) {//通过学号查询
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();

            stmt=conn.createStatement();

            String sql="select * from stu_score where stu_ID = '"+stuID+"'";
            rs=stmt.executeQuery(sql);
            System.out.println();
            System.out.println("    学号            姓名    性别    数据结构    英语    数学    体育    概率    平均分");
            while (rs.next()){
                String stu_id=rs.getString("stu_id");
                String stu_name=rs.getString("stu_name");
                String stu_gender=rs.getString("stu_gender");
                int stu_score_dataStructure=rs.getInt("stu_score_dataStructure");
                int stu_score_english=rs.getInt("stu_score_english");
                int stu_score_math=rs.getInt("stu_score_math");
                int stu_score_PE=rs.getInt("stu_score_PE");
                int stu_score_probability=rs.getInt("stu_score_probability");
                double stu_score_average=rs.getDouble("stu_score_average");
                System.out.println(stu_id+"       "+stu_name+"    "+stu_gender+"      "+stu_score_dataStructure+"        "+stu_score_english+"     "+stu_score_math+"     "+stu_score_PE+"     "+stu_score_probability+"      "+stu_score_average);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,stmt,rs);
        }
    }

    public static void Modify_By_Name(String stuName,int stu_data,int stu_eng,int stu_math,int stu_pe,int stu_pro,double stu_ave) {//通过名字修改
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();

            stmt=conn.createStatement();

            String sql="update stu_score set stu_score_dataStructure = "+stu_data+",stu_score_english = "+stu_eng+",stu_score_math = "+stu_math+",stu_score_PE = "+stu_pe+",stu_score_probability = "+stu_pro+",stu_score_average = "+stu_ave+"  where stu_name = '"+stuName+"'";
            stmt.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,stmt,rs);
        }

    }

    public static void Modify_By_ID(String stuId,int stu_data,int stu_eng,int stu_math,int stu_pe,int stu_pro,double stu_ave) {//通过学号修改
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();

            stmt=conn.createStatement();

            String sql="update stu_score set stu_score_dataStructure = "+stu_data+",stu_score_english = "+stu_eng+",stu_score_math = "+stu_math+",stu_score_PE = "+stu_pe+",stu_score_probability = "+stu_pro+",stu_score_average = "+stu_ave+"  where stu_ID = '"+stuId+"'";
            stmt.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,stmt,rs);
        }
    }

    public static void Delete_By_Name(String stu_name) {//通过名字删除
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();

            stmt=conn.createStatement();

            String sql="delete from stu_score where stu_name = '"+stu_name+"'";
            stmt.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,stmt,rs);
        }
    }

    public static void Delete_By_ID(String stu_id) {//通过学号删除
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();

            stmt=conn.createStatement();

            String sql="delete from stu_score where stu_ID = '"+stu_id+"'";
            stmt.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,stmt,rs);
        }
    }


    public static void Insert_Stu(String stu_id,String stu_name,String stu_sex,float stu_data,float stu_eng,float stu_math,float stu_pe,float stu_pro,double stu_ave) {//插入学生信息
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();

            stmt=conn.createStatement();

            String sql="insert into stu_score(stu_id,stu_name,stu_gender,stu_score_dataStructure,stu_score_english,stu_score_math,stu_score_PE,stu_score_probability,stu_score_average) values('" + stu_id + "','" + stu_name + "','" + stu_sex + "'," + stu_data + "," + stu_eng + "," + stu_math + "," + stu_pe + "," + stu_pro + "," + stu_ave + ")";
            stmt.execute(sql);



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,stmt,rs);
        }


    }



    public static void Sort_By_DataStruct(){//通过数据结构成绩排序
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();

            stmt=conn.createStatement();

            String sql="select * from stu_score order by stu_score_dataStructure DESC ";
            rs=stmt.executeQuery(sql);
            System.out.println("    学号            姓名    性别    数据结构    英语    数学    体育    概率    平均分");
            while (rs.next()){
                String stu_id=rs.getString("stu_id");
                String stu_name=rs.getString("stu_name");
                String stu_gender=rs.getString("stu_gender");
                int stu_score_dataStructure=rs.getInt("stu_score_dataStructure");
                int stu_score_english=rs.getInt("stu_score_english");
                int stu_score_math=rs.getInt("stu_score_math");
                int stu_score_PE=rs.getInt("stu_score_PE");
                int stu_score_probability=rs.getInt("stu_score_probability");
                double stu_score_average=rs.getDouble("stu_score_average");
                System.out.println(stu_id+"       "+stu_name+"    "+stu_gender+"      "+stu_score_dataStructure+"        "+stu_score_english+"     "+stu_score_math+"     "+stu_score_PE+"     "+stu_score_probability+"      "+stu_score_average);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,stmt,rs);
        }
    }

    public static void Sort_By_English(){//通过英语成绩排序
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();

            stmt=conn.createStatement();

            String sql="select * from stu_score order by stu_score_english DESC ";
            rs=stmt.executeQuery(sql);
            System.out.println("    学号            姓名    性别    数据结构    英语    数学    体育    概率    平均分");
            while (rs.next()){
                String stu_id=rs.getString("stu_id");
                String stu_name=rs.getString("stu_name");
                String stu_gender=rs.getString("stu_gender");
                int stu_score_dataStructure=rs.getInt("stu_score_dataStructure");
                int stu_score_english=rs.getInt("stu_score_english");
                int stu_score_math=rs.getInt("stu_score_math");
                int stu_score_PE=rs.getInt("stu_score_PE");
                int stu_score_probability=rs.getInt("stu_score_probability");
                double stu_score_average=rs.getDouble("stu_score_average");
                System.out.println(stu_id+"       "+stu_name+"    "+stu_gender+"      "+stu_score_dataStructure+"        "+stu_score_english+"     "+stu_score_math+"     "+stu_score_PE+"     "+stu_score_probability+"      "+stu_score_average);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,stmt,rs);
        }
    }
    public static void Sort_By_Math(){//通过数学成绩排序
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();

            stmt=conn.createStatement();

            String sql="select * from stu_score order by stu_score_math DESC ";
            rs=stmt.executeQuery(sql);
            System.out.println("    学号            姓名    性别    数据结构    英语    数学    体育    概率    平均分");
            while (rs.next()){
                String stu_id=rs.getString("stu_id");
                String stu_name=rs.getString("stu_name");
                String stu_gender=rs.getString("stu_gender");
                int stu_score_dataStructure=rs.getInt("stu_score_dataStructure");
                int stu_score_english=rs.getInt("stu_score_english");
                int stu_score_math=rs.getInt("stu_score_math");
                int stu_score_PE=rs.getInt("stu_score_PE");
                int stu_score_probability=rs.getInt("stu_score_probability");
                double stu_score_average=rs.getDouble("stu_score_average");
                System.out.println(stu_id+"       "+stu_name+"    "+stu_gender+"      "+stu_score_dataStructure+"        "+stu_score_english+"     "+stu_score_math+"     "+stu_score_PE+"     "+stu_score_probability+"      "+stu_score_average);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,stmt,rs);
        }
    }
    public static void Sort_By_PE(){//通过体育成绩排序
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();

            stmt=conn.createStatement();

            String sql="select * from stu_score order by stu_score_PE DESC ";
            rs=stmt.executeQuery(sql);
            System.out.println("    学号            姓名    性别    数据结构    英语    数学    体育    概率    平均分");
            while (rs.next()){
                String stu_id=rs.getString("stu_id");
                String stu_name=rs.getString("stu_name");
                String stu_gender=rs.getString("stu_gender");
                int stu_score_dataStructure=rs.getInt("stu_score_dataStructure");
                int stu_score_english=rs.getInt("stu_score_english");
                int stu_score_math=rs.getInt("stu_score_math");
                int stu_score_PE=rs.getInt("stu_score_PE");
                int stu_score_probability=rs.getInt("stu_score_probability");
                double stu_score_average=rs.getDouble("stu_score_average");
                System.out.println(stu_id+"       "+stu_name+"    "+stu_gender+"      "+stu_score_dataStructure+"        "+stu_score_english+"     "+stu_score_math+"     "+stu_score_PE+"     "+stu_score_probability+"      "+stu_score_average);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,stmt,rs);
        }
    }
    public static void Sort_By_Probability(){//通过概率成绩排序
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();

            stmt=conn.createStatement();

            String sql="select * from stu_score order by stu_score_probability DESC ";
            rs=stmt.executeQuery(sql);
            System.out.println("    学号            姓名    性别    数据结构    英语    数学    体育    概率    平均分");
            while (rs.next()){
                String stu_id=rs.getString("stu_id");
                String stu_name=rs.getString("stu_name");
                String stu_gender=rs.getString("stu_gender");
                int stu_score_dataStructure=rs.getInt("stu_score_dataStructure");
                int stu_score_english=rs.getInt("stu_score_english");
                int stu_score_math=rs.getInt("stu_score_math");
                int stu_score_PE=rs.getInt("stu_score_PE");
                int stu_score_probability=rs.getInt("stu_score_probability");
                double stu_score_average=rs.getDouble("stu_score_average");
                System.out.println(stu_id+"       "+stu_name+"    "+stu_gender+"      "+stu_score_dataStructure+"        "+stu_score_english+"     "+stu_score_math+"     "+stu_score_PE+"     "+stu_score_probability+"      "+stu_score_average);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,stmt,rs);
        }
    }
    public static void Sort_By_Average(){//通过平均成绩排序
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();

            stmt=conn.createStatement();

            String sql="select * from stu_score order by stu_score_average DESC ";
            rs=stmt.executeQuery(sql);
            System.out.println("    学号            姓名    性别    数据结构    英语    数学    体育    概率    平均分");
            while (rs.next()){
                String stu_id=rs.getString("stu_id");
                String stu_name=rs.getString("stu_name");
                String stu_gender=rs.getString("stu_gender");
                int stu_score_dataStructure=rs.getInt("stu_score_dataStructure");
                int stu_score_english=rs.getInt("stu_score_english");
                int stu_score_math=rs.getInt("stu_score_math");
                int stu_score_PE=rs.getInt("stu_score_PE");
                int stu_score_probability=rs.getInt("stu_score_probability");
                double stu_score_average=rs.getDouble("stu_score_average");
                System.out.println(stu_id+"       "+stu_name+"    "+stu_gender+"      "+stu_score_dataStructure+"        "+stu_score_english+"     "+stu_score_math+"     "+stu_score_PE+"     "+stu_score_probability+"      "+stu_score_average);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,stmt,rs);
        }
    }

    public static void Read_File(){//读取数据库
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //注册驱动，获取连接
            conn = DBUtil.getConnection();

            //获取数据库操作对象
            stmt = conn.createStatement();

            //执行sql语句
            String sql="select * from stu_score";
            rs=stmt.executeQuery(sql);
            System.out.println("    学号            姓名    性别    数据结构    英语    数学    体育    概率    平均分");
            while (rs.next()){
                String  stu_id=rs.getString("stu_id");
                String stu_name=rs.getString("stu_name");
                String stu_gender=rs.getString("stu_gender");
                int stu_score_dataStructure=rs.getInt("stu_score_dataStructure");
                int stu_score_english=rs.getInt("stu_score_english");
                int stu_score_math=rs.getInt("stu_score_math");
                int stu_score_PE=rs.getInt("stu_score_PE");
                int stu_score_probability=rs.getInt("stu_score_probability");
                double stu_score_average=rs.getDouble("stu_score_average");
                System.out.println(stu_id+"       "+stu_name+"    "+stu_gender+"      "+stu_score_dataStructure+"        "+stu_score_english+"     "+stu_score_math+"     "+stu_score_PE+"     "+stu_score_probability+"      "+stu_score_average);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DBUtil.close(conn, stmt, rs);
        }
    }

















    public static void main(String[] args) {
        char c;
        boolean flag_main = false;
        Function.displayMenu();
        Scanner sc = new Scanner(System.in);
        String s_ID_number;
        String s_name;
        String s_sex;
        int s_DataStructScore;
        int s_EnglishScore;
        int s_MathScore;
        int s_PEScore;
        int s_ProbabilityScore;
        double s_average;
        do {
            do {
                c = sc.next().charAt(0);
                if (c >= 'a' && c <= 'k') {
                    flag_main = true;
                } else {
                    System.out.println("输入的指令错误");
                    System.out.println("请重新输入正确的指令");
                }
            } while (!flag_main);

            switch (c) {
                case 'a': {
                    char f;
                    System.out.println("******************现在进行学生信息查询******************");
                    System.out.println("请选择查询方式：");
                    System.out.println("(0)——按姓名查询\t(1)——按学号查询\t(2)——退出查询");
                    f = sc.next().charAt(0);
                    while (f != '0' && f != '1' && f != '2') {
                        System.out.println("指令错误（请选择(0)、(1)或(2)）");
                        System.out.println("请选择查询方式：");
                        System.out.println("(0)——按姓名查询\t(1)——按学号查询\t(2)——退出查询");
                        f = sc.next().charAt(0);
                    }
                    if (f == '2') {
                        Function.displayMenu();
                        break;
                    } else {
                        switch (f) {
                            case '0': {
                                String name;
                                System.out.println("请输入查询的学生姓名：");
                                name = sc.next();
                                Search_By_Name(name);
                                break;
                            }
                            case '1':
                                String id;
                                System.out.println("请输入查询的学生学号：");
                                id = sc.next();
                                Search_By_ID(id);
                                break;
                            default:
                                break;
                        }
                        System.out.println("***************************************************");
                        Function.displayMenu();
                        break;
                    }
                }
                case 'b': {
                    char m=' ';
                    System.out.println("******************现在进行学生信息修改******************");
                    System.out.println("请选择修改方式：");
                    System.out.println("(0)——按姓名修改\t(1)——按学号修改\t(2)——退出修改");
                    m = sc.next().charAt(0);
                    while (m != '0' && m != '1' && m != '2') {
                        System.out.println("指令错误（请选择(0)、(1)或(2)）");
                        System.out.println("请选择查询方式：");
                        System.out.println("(0)——按姓名修改\t(1)——按学号修改\t(2)——退出修改");
                        m = sc.next().charAt(0);
                    }
                    if (m == '2') {
                        Function.displayMenu();
                        break;
                    } else {
                        switch (m) {
                            case '0': {
                                String name;
                                System.out.println("请输入修改的学生姓名：");
                                name = sc.next();
                                System.out.println("输入新的成绩");
                                System.out.println("请输入数据结构成绩：");
                                s_DataStructScore = sc.nextInt();
                                System.out.println("请输入英语成绩：");
                                s_EnglishScore = sc.nextInt();
                                System.out.println("请输入数学成绩：");
                                s_MathScore = sc.nextInt();
                                System.out.println("请输入体育成绩：");
                                s_PEScore = sc.nextInt();
                                System.out.println("请输入概率论成绩：");
                                s_ProbabilityScore = sc.nextInt();
                                s_average = (s_DataStructScore + s_MathScore + s_EnglishScore + s_PEScore + s_ProbabilityScore) / 5.0;

                                Modify_By_Name(name,s_DataStructScore,s_EnglishScore,s_MathScore,s_PEScore,s_ProbabilityScore,s_average);
                                break;
                            }
                            case '1': {
                                String id;
                                System.out.println("请输入修改的学生学号：");
                                id = sc.next();
                                System.out.println("输入新的成绩");
                                System.out.println("请输入数据结构成绩：");
                                s_DataStructScore = sc.nextInt();
                                System.out.println("请输入英语成绩：");
                                s_EnglishScore = sc.nextInt();
                                System.out.println("请输入数学成绩：");
                                s_MathScore = sc.nextInt();
                                System.out.println("请输入体育成绩：");
                                s_PEScore = sc.nextInt();
                                System.out.println("请输入概率论成绩：");
                                s_ProbabilityScore = sc.nextInt();
                                s_average = (s_DataStructScore + s_MathScore + s_EnglishScore + s_PEScore + s_ProbabilityScore) / 5.0;

                                Modify_By_ID(id,s_DataStructScore,s_EnglishScore,s_MathScore,s_PEScore,s_ProbabilityScore,s_average);
                                break;
                            }
                        }
                        Function.displayMenu();
                        break;
                    }
                }
                case 'c': {
                    char d = ' ';
                    System.out.println("******************现在进行学生信息删除******************");
                    System.out.println("请选择删除方式：");
                    System.out.println("(0)——按姓名删除\t(1)——按学号删除\t(2)——退出删除");
                    d = sc.next().charAt(0);
                    while (d != '1' && d != '0' && d != '2') {
                        System.out.println("指令错误（请选择(0)、(1)或(2)）");
                        System.out.println("请选择删除方式：");
                        System.out.println("(0)——按姓名删除\t(1)——按学号删除\t(2)——退出删除");
                        d = sc.next().charAt(0);
                    }
                    if (d == '2') {
                        Function.displayMenu();
                        break;
                    }
                    switch (d) {
                        case '0': {
                            String name;
                            System.out.println("请输入查询的学生姓名：");
                            name = sc.next();
                            Delete_By_Name(name);
                            break;
                        }
                        case '1': {
                            String id;
                            System.out.println("请输入查询的学生学号：");
                            id = sc.next();
                            Delete_By_ID(id);
                            break;
                        }
                    }
                    Function.displayMenu();
                    break;
                }
                case 'd': {
                    System.out.println("******************现在进行学生信息插入******************");
                    char c1 = ' ';

                    do {
                        System.out.println("请输入学号(13位)：");
                        s_ID_number = sc.next();
                        System.out.println("请输入姓名：");
                        s_name = sc.next();
                        System.out.println("请输入性别：");
                        s_sex = sc.next();
                        System.out.println("请输入数据结构成绩：");
                        s_DataStructScore = sc.nextInt();
                        System.out.println("请输入英语成绩：");
                       s_EnglishScore = sc.nextInt();
                        System.out.println("请输入数学成绩：");
                        s_MathScore = sc.nextInt();
                        System.out.println("请输入体育成绩：");
                        s_PEScore = sc.nextInt();
                        System.out.println("请输入概率论成绩：");
                        s_ProbabilityScore = sc.nextInt();
                        s_average = (s_DataStructScore + s_MathScore + s_EnglishScore + s_PEScore + s_ProbabilityScore) / 5.0;

                        System.out.println("插入成功，是否继续插入？(y/n)");
                        c1 = sc.next().charAt(0);
                        while (c1 != 'y' && c1 != 'n') {
                            System.out.println("输入的指令错误，请重新输入！");
                            System.out.println("插入成功，是否继续插入？(y/n)");
                            c1 = sc.next().charAt(0);
                        }

                    } while (c1 == 'y');
                    Insert_Stu(s_ID_number,s_name,s_sex,s_DataStructScore,s_EnglishScore,s_MathScore,s_PEScore,s_ProbabilityScore,s_average);
                    System.out.println("****************************************************");
                    Function.displayMenu();
                    break;
                }
                case 'e': {
                    int s;
                    System.out.println("******************现在进行排序******************");
                    System.out.println("请选择排序方式");
                    System.out.println("1、按数据结构成绩排序");
                    System.out.println("2、按英语成绩排序");
                    System.out.println("3、按数学成绩排序");
                    System.out.println("4、按体育成绩排序");
                    System.out.println("5、按概率成绩排序");
                    System.out.println("6、按平均分排序");
                    s=sc.nextInt();
                    while (s<1||s>6){
                        System.out.println("输入的指令错误（请选择(1-6)）");
                        System.out.println("请选择排序方式");
                        System.out.println("1、按数据结构成绩排序");
                        System.out.println("2、按英语成绩排序");
                        System.out.println("3、按数学成绩排序");
                        System.out.println("4、按体育成绩排序");
                        System.out.println("5、按概率成绩排序");
                        System.out.println("6、按平均分排序");
                        s=sc.nextInt();
                    }
                    switch (s)
                    {
                        case 1 :Sort_By_DataStruct(); break;
                        case 2 :Sort_By_English(); break;
                        case 3 :Sort_By_Math(); break;
                        case 4 :Sort_By_PE(); break;
                        case 5 :Sort_By_Probability(); break;
                        case 6 :Sort_By_Average(); break;
                    }
                    System.out.println("****************************************************");
                    Function.displayMenu();
                    break;
                }
                case 'f':{
                    System.out.println("******************现在进行数据库读取******************");
                    Read_File();
                    System.out.println("****************************************************");
                    Function.displayMenu();
                    break;
                }
                case 'g':{
                    System.out.println("****************************************************");
                    System.out.println( "您已成功退出学生成绩管理系统，感谢使用！！！");
                    System.out.println("****************************************************");
                    System.exit(0);
                    break;
                }

            }
        } while (flag_main);
    }
}
