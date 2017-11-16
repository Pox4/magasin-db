package fr.sopra.magasindb;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import fr.sopra.Categorie;
import fr.sopra.Fabriquant;
import fr.sopra.GestionDesProduits;
import fr.sopra.Produit;

@RunWith(Arquillian.class)
public class GestionDesProduitsTest {

	@Deployment
	public static Archive<?> createDeployment() {

		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(GestionDesProduits.class.getPackage())
				.addPackage(Categorie.class.getPackage())
				.addPackage(Fabriquant.class.getPackage())
				.addPackage(Produit.class.getPackage())
				.addAsLibraries(
						Maven.resolver().resolve("org.apache.poi:poi:3.17").withTransitivity().as(JavaArchive.class))
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	}

	@EJB
	private GestionDesProduits gestion;

	@Test
	public void haveNameAndId() {

		Categorie categorie = new Categorie();
		categorie.setNom("test");
		Assert.assertSame("name is test", "test", categorie.getNom());

	}

	@Test
	public void findId() {

		Categorie categorie = new Categorie();
		gestion.ajouterCategorie(categorie);

		
		Assert.assertTrue(categorie == gestion.findCategorieById(categorie.getId()));

	}

}
