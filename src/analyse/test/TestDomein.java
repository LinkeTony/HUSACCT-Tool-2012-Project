package analyse.test;

import analyse.domain.analyseservice.AnalyseController;
import analyse.domain.analyseservice.dto.AnalysedModuleDTO;
import analyse.domain.analyseservice.dto.DependencyDTO;
import junit.framework.*;


public class TestDomein extends TestCase{

	private AnalyseController service;
	
	public void setUp(){
		service = new AnalyseController();
	}
	
	public void testAvailableLanguages(){
		String[] languages = service.getAvailableLanguages();
		assertEquals("Java", languages[0]);
		assertEquals("C#", languages[1]);
	}

	public void testGetModules(){
		AnalysedModuleDTO[] modules = service.getModules();		
		assertEquals(2, modules.length);
		assertEquals("domain", modules[0].name);
		assertEquals("infrastructure", modules[1].name);
		assertEquals("domain", modules[0].uniqueName);
		assertEquals("infrastructure", modules[1].uniqueName);
		assertNull(modules[0].subModules);
		assertNull(modules[1].subModules);
	}
	
	public void testGetChildInModule(){
		AnalysedModuleDTO[] modules = service.getChildModulesInModule("domain.locationbased");
		assertEquals(2, modules.length);
		assertEquals("domain.locationbased.latitude", modules[1].uniqueName);
		assertEquals("domain.locationbased.foursquare", modules[0].uniqueName);
		
		
		assertEquals("Account", modules[0].subModules.get(0).name);
		assertEquals("domain.locationbased.foursquare.Account", modules[0].subModules.get(0).uniqueName);
		
		assertEquals("Friends", modules[0].subModules.get(1).name);
		assertEquals("domain.locationbased.foursquare.Friends", modules[0].subModules.get(1).uniqueName);
		
		assertEquals("Map", modules[0].subModules.get(2).name);
		assertEquals("domain.locationbased.foursquare.Map", modules[0].subModules.get(2).uniqueName);
		
		assertEquals("History", modules[0].subModules.get(3).name);
		assertEquals("domain.locationbased.foursquare.History", modules[0].subModules.get(3).uniqueName);
	}
	
	public void testGetChildModulesInDepth(){
		AnalysedModuleDTO[] modules = service.getChildModulesInModule("domain.locationbased", 2);
		
		assertEquals("domain.locationbased.foursquare", modules[0].uniqueName);
		assertEquals("domain.locationbased.foursquare.Account", modules[0].subModules.get(0).uniqueName);
		assertNull(modules[0].subModules.get(0).subModules);
		
	}
	
	public void testGetParentModule(){
		AnalysedModuleDTO module = service.getParentModule("domain.locationbased.foursquare");
		
		assertEquals("domain.locationbased", module.uniqueName);
				
	}
	
	public void testGetDependencyFromAndTo(){
		DependencyDTO[] dependencies = service.getDependency("domain.locationbased.foursquare.History", "infrastructure.socialmedia.locationbased.foursquare.HistoryDAO");		
		assertEquals(1, dependencies.length);
	}
		
	public void testGetDependencyFrom(){
		DependencyDTO[] dependencies = service.getDependency("domain.locationbased.foursquare.History", "infrastructure.socialmedia.locationbased.foursquare.HistoryDAO");		
		assertEquals(1, dependencies.length);
	}
	
	public void testGetDependencyFromAndToPackageLevel(){
		DependencyDTO[] dependencies = service.getDependency("domain.locationbased.foursquare", "infrastructure.socialmedia.locationbased.foursquare");		
		assertEquals(4, dependencies.length);
	}
	
	public void testGetDependencyFromPackageLevel(){
		DependencyDTO[] dependencies = service.getDependency("domain.locationbased.foursquare");		
		assertEquals(4, dependencies.length);
	}
	
	
	



	
}
