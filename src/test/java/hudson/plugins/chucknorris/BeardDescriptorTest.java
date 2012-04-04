package hudson.plugins.chucknorris;

import hudson.model.AbstractProject;
import junit.framework.TestCase;

import static org.mockito.Mockito.mock;

public class BeardDescriptorTest extends TestCase {

	private BeardDescriptor descriptor;

	public void setUp() {
		descriptor = new BeardDescriptor();
	}

	public void testGetDisplayName() {
		assertEquals("Activate Rage Norris", descriptor.getDisplayName());
	}

	public void testIsApplicableGivesTrue() {
		assertTrue(descriptor.isApplicable(mock(AbstractProject.class)
				.getClass()));
	}
}
