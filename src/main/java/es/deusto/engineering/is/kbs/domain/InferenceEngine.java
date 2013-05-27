package es.deusto.engineering.is.kbs.domain;

import org.drools.KnowledgeBase;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import es.deusto.engineering.is.kbs.domain.Occupation.Type;
import es.deusto.ingenieria.is.drools.util.KnowledgeBaseLoader;

public class InferenceEngine {

	public static void main(String[] args) {
		try {

			// The knowledge base made up of a rules file ".drl", is loaded
			KnowledgeBase kBase = KnowledgeBaseLoader.getInstance().loadKnowledgeBase("eligibility.drl");

			// The working memory is created. drools calls it Knowledge session
			StatefulKnowledgeSession kSession = kBase.newStatefulKnowledgeSession();

			// The log for the inference process is initialized
			KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(kSession, "log/log");

			RentOffer offer1 = new RentOffer(1, 800);
			RentOffer offer2 = new RentOffer(2, 900);

			Occupation occ1 = new Occupation(30, "Hogwarts", Type.STUDIES);
			Occupation occ2 = new Occupation(40, "IT Deusto", Type.EMPLOYMENT);
			Occupation occ3 = new Occupation(20, "Ctro Formacion 1",
					Type.STUDIES);
			Occupation occ4 = new Occupation(20, "Iberdrola", Type.EMPLOYMENT);

			PotentialTenant tenant1 = new PotentialTenant("John Smith", false,
					true);
			tenant1.setBalance(850);
			AccountHolder parents1 = new AccountHolder("Peter Smith", 1000,
					true, true, true);
			tenant1.setFamily(parents1);
			// John Smith is a part time student and part time employee with no
			// children under 4 and a dog
			tenant1.addOccupation(occ3);
			tenant1.addOccupation(occ4);

			PotentialTenant tenant2 = new PotentialTenant("Alice Wonderland",
					false, false);
			// Alice Wonderland is a full time employee with NO children under 4
			// and no dog
			tenant2.addOccupation(occ2);
			tenant2.setBalance(1600);
			tenant2.setPaysDeposit(true);

			PotentialTenant tenant3 = new PotentialTenant("Harry Potter",
					false, false);
			AccountHolder parents2 = new AccountHolder("Lily Potter", 10000,
					true, true, true);
			// Harry Potter is a full time student with no children under 4 and
			// no dog
			tenant3.addOccupation(occ1);
			tenant3.setFamily(parents2);
			tenant3.setBalance(700);

			Adequacy ad1 = new Adequacy(tenant1, offer1);
			Adequacy ad2 = new Adequacy(tenant1, offer2);
			Adequacy ad3 = new Adequacy(tenant2, offer1);
			Adequacy ad4 = new Adequacy(tenant2, offer2);
			Adequacy ad5 = new Adequacy(tenant3, offer1);
			Adequacy ad6 = new Adequacy(tenant3, offer2);

			// Before the inference process
			System.out.println("BEFORE THE INFERENCE PROCESS");
			System.out.println("------ --- --------- -------");

			System.out.println("\n" + tenant1);
			System.out.println("\n" + tenant2);
			System.out.println("\n" + tenant3);

			// Insert information into the working memory
			// every object that may suffer a change within the rules
			// consequents
			// must be in the working memory
			kSession.insert(tenant1);
			kSession.insert(tenant2);
			kSession.insert(tenant3);

			kSession.insert(offer1);
			kSession.insert(offer2);
			kSession.insert(ad1);
			kSession.insert(ad2);
			kSession.insert(ad3);
			kSession.insert(ad4);
			kSession.insert(ad5);
			kSession.insert(ad6);

			// System.out.println("\nDURING THE INFERENCE PROCESS");
			System.out.println("------ --- --------- -------");

			// Invoke the inference mechanism
			kSession.fireAllRules();

			// Close the inference process log
			logger.close();

			// After inference process
			System.out.println("\nAFTER THE INFERENCE PROCESS");
			System.out.println("----- --- --------- -------");

			System.out.println("\n" + tenant1);
			System.out.println("\n" + tenant2);
			System.out.println("\n" + tenant3);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("MainProgram: " + ex.getMessage());
		}
	}
}