package empapp.entity;

import org.hibernate.envers.RevisionListener;

public class StubUsernameListenes implements RevisionListener {

    @Override
    public void newRevision(Object o) {
        if (o instanceof EmployeeRevisionEntity revision) {
            revision.setModifiedBy("admin");
        }
    }
}
