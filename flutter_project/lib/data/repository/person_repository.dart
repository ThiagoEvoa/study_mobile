import 'package:flutter/material.dart';
import 'package:flutter_project/data/datasource/person_datasource.dart';
import 'package:flutter_project/data/model/person_model.dart';
import 'package:flutter_project/domain/repository/iperson_repository.dart';

class PersonRepository implements IPersonRepository {
  PersonDataSource _personDataSource = PersonDataSource();

  @override
  retrievePeople() {
    return _personDataSource.retrievePeople();
  }

  @override
  savePerson({@required PersonModel personModel}) {
    return _personDataSource.savePerson(personModel: personModel);
  }

  @override
  updatePerson({PersonModel personModel}) {
    return _personDataSource.updatePerson(personModel: personModel);
  }

  @override
  deletePerson({PersonModel personModel}) {
    return _personDataSource.deletePerson(personModel: personModel);
  }
}
