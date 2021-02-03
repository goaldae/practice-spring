package springTest.data;

import java.util.Iterator;

import springTest.Hamburger;

public interface HamburgerRepository {
	Iterator<Hamburger> findAll();
	Hamburger save(Hamburger hamburger);
}
