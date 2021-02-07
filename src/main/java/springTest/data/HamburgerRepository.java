package springTest.data;

import springTest.Hamburger;

public interface HamburgerRepository {
	Iterable<Hamburger> findAll();
	Hamburger save(Hamburger hamburger);
}
