import 'package:flutter/material.dart';
import 'package:flutter_project/data/model/person_model.dart';

abstract class IPersonRepository {
  retrievePeople();
  savePerson({@required PersonModel personModel});
  updatePerson({@required PersonModel personModel});
  deletePerson({@required PersonModel personModel});
}
