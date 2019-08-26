package Dao;

import Service.car;
import Service.seat;
import Service.user;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCutils;

import java.util.List;

public class Dao {
    //声明JDBCtemp
    private JdbcTemplate template= new JdbcTemplate(JDBCutils.getDataSource());
    public user login(user loginUser){
        try {
            String sql="select * from user where username= ? and password =?";
            //调用query
            user user=template.queryForObject(sql,new BeanPropertyRowMapper<user>(user.class),
                    loginUser.getUsername(),loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
            return null;
        }
    }
    public void add(user user){
        String sql="insert into user values(?,?,?,?,?)";
        template.update(sql,user.getName(),user.getUsername(),user.getPassword(),user.getSex(),user.getPhone());
    }
    public List<car> selectCar(String username){
        try {
            String sql="select * from in_cars where owner= ?";
            List<car> cars=template.query(sql,new BeanPropertyRowMapper<car>(car.class),username);
            return cars ;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<seat> selectseat(){
        try {
            String sql="select * from position where empty= 1";
            List<seat> seats=template.query(sql,new BeanPropertyRowMapper<seat>(seat.class));
            return seats ;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void occupy(String seat,String car_number){
        String sql="update position set empty=0,car_number=? where position=? ";
        template.update(sql,car_number,seat);
    }
    public void carAdd(car car,String username){
        String sql="insert into in_cars values(?,?,?,?,?,?)";
        template.update(sql,car.getCar_number(),car.getCar_brand(), car.getCar_intime(),car.getCar_info(),car.getCar_position(),username);
    }
    public void carExit(String car_number){
        String sql="DELETE FROM in_cars WHERE car_number = ?";
        template.update(sql,car_number);

    }
    public car carSelect(String car_number){
        String sql="select * from in_cars where car_number= ?";
        car car=template.queryForObject(sql,new BeanPropertyRowMapper<car>(car.class),car_number);
        return car;
    }
    public void positionDelete(String car_number){
        String sql="update position set empty=1,car_number=null where car_number=? ";
        template.update(sql,car_number);
    }

}
