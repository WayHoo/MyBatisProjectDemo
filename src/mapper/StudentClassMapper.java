package mapper;

import entity.StudentClass;

public interface StudentClassMapper {
    StudentClass lazyQueryClassByClassId(int classId);
}
