/*package com.cubic.it.cars.dao;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.it.cars.entity.CarEntity;
import com.cubic.it.cars.entity.CarPriceEntity;
import com.cubic.it.cars.entity.UserEntity;
*/

//<tx:annotation-driven proxy-target-class="true"	transaction-manager="transactionManager" />
/*@Repository
//below is mandatory 
@Transactional
public class CarDaoImpl  implements CarDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
        return sessionFactory.getCurrentSession();
   }
	
	@Override
	public UserEntity validateUser(String username,String password) {
		TypedQuery<UserEntity> query=getSession().createQuery("from UserEntity pt where pt.userid=:pusername and pt.password=:ppassword"); //HQL
		query.setParameter("pusername", username);
		query.setParameter("ppassword", password);
		UserEntity  profileEntity=null;
		 try {
			 profileEntity=query.getSingleResult();
		 }catch (Exception e) {
			 //e.printStackTrace();
		}
		return profileEntity;
	}
	
	@Override
	public byte[] loadImage(int rid) {
		//if you know primary key of entity then you can load it;s data
		CarEntity carEntity=this.getSession().get(CarEntity.class, rid);
		return carEntity.getImage();
	}
	
	
	@Override
	public int findAllCount() {
		Query query=this.getSession().createQuery("from CarEntity");
		List<CarEntity> listCars= query.list();
		return listCars.size();
	}
	
	@Override
	public void delete(int cid) {
		Session tsession=this.getSession();
		CarEntity carEntity=tsession.get(CarEntity.class, cid);
		tsession.delete(carEntity);
	}
	
	//9:30 PM -AWS Class  -11:00 PM  -Saturday & Sunday - AWS - 
	@Override
	public List<CarEntity> findByPage(int startPage,int pageSize) { //1 , 4   = 1,2,3,4
		Query query = this.getSession().createQuery("From CarEntity");
		query.setFirstResult(startPage-1); //starts with zero ->> that's why minus 1
		query.setMaxResults(pageSize);
		List<CarEntity> carLista = query.list();
		return carLista;
	}
	
	@Override
	public List<CarEntity> findAll() {
		Query query=this.getSession().createQuery("from CarEntity");
		return  query.list();
	}
	
	@Override
	public void updatePhoto(CarEntity carEntity) throws IOException {
		if(carEntity.getPhoto()!=null && carEntity.getPhoto().getBytes().length>0) {
			//entity is loaded inside persistence context
			CarEntity scarEntity=this.getSession().get(CarEntity.class,carEntity.getId());
			scarEntity.setImage(carEntity.getPhoto().getBytes());
		}
	}
	
	@Override
	@Transactional
	public void save(CarEntity carEntity) throws IOException {
		
		byte[] image=null;
		if(carEntity.getPhoto()!=null) {
		     image=carEntity.getPhoto().getBytes();
		     carEntity.setFilename(carEntity.getPhoto().getName());
		}
		carEntity.setImage(image);
		carEntity.setDoe(new Timestamp(new Date().getTime()));
		carEntity.setDom(new Timestamp(new Date().getTime()));
		int currentPrimary=(Integer)this.getSession().save(carEntity);
		
		CarPriceEntity carPriceEntity=new CarPriceEntity();
		carPriceEntity.setCid(currentPrimary);
		carPriceEntity.setPrice(carEntity.getPrice()+"$");
		carPriceEntity.setDoe(new Timestamp(new Date().getTime()));
		this.getSession().save(carPriceEntity);
	}
	

}*/
