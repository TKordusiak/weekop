package pl.javastat.service;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import pl.javastart.dao.DAOFactory;
import pl.javastart.dao.DiscoveryDAO;
import pl.javastart.model.Discovery;
import pl.javastart.model.User;

public class DiscoveryService {
		public void addDiscovery(String name, String desc, String url, User user) {
			Discovery discovery = createDiscoveryObject(name, desc, url, user);
			DAOFactory factory = DAOFactory.getDAOFactory();
			DiscoveryDAO discoveryDao = factory.getDiscoveryDAO();
			discoveryDao.create(discovery);
		}
		
		private Discovery createDiscoveryObject(String name, String desc, String url, User user) {
			Discovery discovery = new Discovery();
			discovery.setName(name);
			discovery.setDescription(desc);
			discovery.setUrl(url);
			User userCopy = new User(user);
			discovery.setUser(userCopy);
			discovery.setTimestamp(new Timestamp(new Date().getTime()));
			return discovery;
		}
		
		public Discovery getDiscoveryById(long discoveryId) {
			DAOFactory factory = DAOFactory.getDAOFactory();
			DiscoveryDAO discoveryDao = factory.getDiscoveryDAO();
			Discovery discovery = discoveryDao.read(discoveryId);
			return discovery;
		}
		
		public boolean updateDiscovery(Discovery discovery) {
			DAOFactory Factory = DAOFactory.getDAOFactory();
			DiscoveryDAO discoveryDao = Factory.getDiscoveryDAO();
			boolean result = discoveryDao.update(discovery);
			return result;
			
		}
		
		public List<Discovery> getAllDiscoveries(){
			return getAllDiscoveries(null);
			
		}

		public List<Discovery> getAllDiscoveries(Comparator<Discovery> comparator) {
			DAOFactory factory = DAOFactory.getDAOFactory();
			DiscoveryDAO discoveryDao = factory.getDiscoveryDAO();
			List<Discovery> discoveries = discoveryDao.getAll();
			if(comparator != null && discoveries != null) {
				discoveries.sort(comparator);
			}
			return discoveries;
		}
	}